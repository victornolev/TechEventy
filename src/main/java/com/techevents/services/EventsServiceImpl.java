package com.techevents.services;

import com.techevents.entities.Event;
import com.techevents.entities.enumerations.EventPreferenceType;
import com.techevents.exceptions.entity.InvalidEventException;
import com.techevents.repositories.base.GenericRepository;
import com.techevents.services.base.EventsService;
import com.techevents.validation.base.Validator;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class EventsServiceImpl implements EventsService {
  private final GenericRepository<Event> eventRepository;
  private final Validator<Event> eventValidator;

  //TODO (OOP) Is it a good idea to implement this service here, access the needed category and get all events only from that category (without the need to iterate all of the events and each category of current event)
//  private final CategoriesService categoriesService;

  public EventsServiceImpl(GenericRepository<Event> eventRepository, Validator<Event> eventValidator) {
    this.eventRepository = eventRepository;
    this.eventValidator = eventValidator;
  }

  @Override
  public List<Event> getAllEvents() {
    return eventRepository.getAll();
  }

  @Override
  public List<Event> getAllEventsByPreference(String preferenceName, LocalDateTime currentDateTime) {

    EventPreferenceType preferenceType = EventPreferenceType.valueOf(preferenceName.replace(' ', '_').toUpperCase());

    List<Event> events;
    switch (preferenceType) {
      case PAST:
        events = getPastEvents(currentDateTime);
        break;
      case UPCOMING:
        events = getUpcomingEvents(currentDateTime);
        break;
      case THIS_MONTH:
        events = getEventsByThisMonth(currentDateTime);
        break;
      case NEXT_MONTH:
        events = getEventsByNextMonth(currentDateTime);
        break;

      default:
        throw new NoSuchElementException("There is no preference from this type: " + preferenceName);
    }
    return events;
  }

  @Override
  public List<Event> getPastEvents(LocalDateTime currentDateTime) {
    List<Event> events = eventRepository.getAll();

    return events.stream()
      .filter(event -> event.getDateTime() != null)
      .filter(event -> event.getDateTime().isBefore(currentDateTime))
      .collect(Collectors.toList());
  }

  @Override
  public List<Event> getUpcomingEvents(LocalDateTime currentDateTime) {
    List<Event> events = eventRepository.getAll();

    return events.stream()
      .filter(event -> event.getDateTime() != null)
      .filter(event -> event.getDateTime().isAfter(currentDateTime))
      .collect(Collectors.toList());
  }

  @Override
  public List<Event> getEventsByThisMonth(LocalDateTime currentDateTime) {
    List<Event> events = eventRepository.getAll();

    return events.stream()
      .filter(event -> event.getDateTime() != null)
      .filter(event -> event.getDateTime().getYear() == currentDateTime.getYear())
      .filter(event -> event.getDateTime().getMonth() == currentDateTime.getMonth())
      .collect(Collectors.toList());
  }

  @Override
  public List<Event> getEventsByNextMonth(LocalDateTime currentDateTime) {
    List<Event> events = eventRepository.getAll();

    return events.stream()
      .filter(event -> event.getDateTime() != null)
      .filter(event -> event.getDateTime().getYear() == currentDateTime.getYear())
      .filter(event -> event.getDateTime().getMonth() == currentDateTime.getMonth().plus(1))
      .collect(Collectors.toList());
  }

  @Override
  public List<Event> getEventsByOrganiser(String organiserName) {
    List<Event> events = eventRepository.getAll();

    return events.stream()
      .filter(event -> event.getOrganisers()
        .stream()
        .anyMatch(organiser -> organiser.getName().toLowerCase().equals(organiserName.toLowerCase()))
      )
      .collect(Collectors.toList());
  }

  @Override
  public Event getEventById(int id) {
    return eventRepository.getById(id);
  }

  @Override
  public List<Event> getAllEventsByCategory(String categoryName) {

    List<Event> events = eventRepository.getAll();

    return events.stream()
      .filter(event -> event.getCategories()
        .stream()
        .anyMatch(category -> category.getName().toLowerCase().equals(categoryName.toLowerCase()))
      )
      .collect(Collectors.toList());
  }

  // Maybe it would be better to use hibernate search custom implementation
  @Override
  public List<Event> findEventsByName(String eventName) {
    List<Event> events = eventRepository.getAll();

    return events.stream()
      .filter(event -> event.getName().contains(eventName))
      .collect(Collectors.toList());
  }

  @Override
  public void createEvent(Event event) throws InvalidEventException {
    if (!eventValidator.isValid(event)) {
      throw new InvalidEventException("Invalid data for fields of event: " + event);
    }
    eventRepository.create(event);
  }
}
