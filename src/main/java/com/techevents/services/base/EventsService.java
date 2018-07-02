package com.techevents.services.base;

import com.techevents.entities.Event;
import com.techevents.entities.Organiser;
import com.techevents.entities.enumerations.EventPreferenceType;
import com.techevents.exceptions.entity.InvalidEventException;

import java.io.InvalidObjectException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface EventsService {
  List<Event> getAllEvents();

  List<Event> getAllEventsByPreference(String preferenceName, LocalDateTime currentDateTime);

  List<Event> getPastEvents(LocalDateTime currentDateTime);

  List<Event> getUpcomingEvents(LocalDateTime currentDateTime);

  List<Event> getEventsByThisMonth(LocalDateTime currentDateTime);

  List<Event> getEventsByNextMonth(LocalDateTime currentDateTime);

  List<Event> getEventsByOrganiser(String organiserName);

  Event getEventById(int id);

  List<Event> getAllEventsByCategory(String categoryName);

  List<Event> findEventsByName(String eventName);

  void createEvent(Event event) throws InvalidEventException;
}

