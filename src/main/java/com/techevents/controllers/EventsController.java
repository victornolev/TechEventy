package com.techevents.controllers;

import com.techevents.entities.Category;
import com.techevents.entities.Event;
import com.techevents.entities.Organiser;
import com.techevents.entities.enumerations.EventPreferenceType;
import com.techevents.services.base.CategoriesService;
import com.techevents.services.base.EventsService;
import com.techevents.utils.loggers.base.LoggerProvider;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@Controller
public class EventsController {

  private final EventsService eventsService;

  private final CategoriesService categoriesService;

  private final LoggerProvider<EventsController> logger;

  public EventsController(EventsService eventsService, CategoriesService categoriesService, LoggerProvider<EventsController> logger) {
    this.eventsService = eventsService;
    this.categoriesService = categoriesService;

    this.logger = logger;
    this.logger.setClass(EventsController.class);
  }

  @GetMapping("/events")
  public String showEventsWithCategories(@RequestParam(value = "search", required = false)
                                           String searchString,
                                         Model model) {

    List<Event> events;

    if (searchString != null) {
      logger.info("Searching events with name, containing this string: " + "'" + searchString + "'");
      events = eventsService.findEventsByName(searchString);
    }
    else {
      logger.info("Showing all events");
      events = eventsService.getAllEvents();
    }

    List<Category> categories = categoriesService.getAllCategories();
    logger.info("Categories are: " + categories.size());

    String eventsCategory = "All events";

    Set<EventPreferenceType> preferences = EnumSet.allOf(EventPreferenceType.class);
    List<EventPreferenceType> preferenceTypes = new ArrayList<>(preferences);

    model.addAttribute("events", events);
    model.addAttribute("categories", categories);
    model.addAttribute("eventsCategory", eventsCategory);
    model.addAttribute("eventPreferenceTypes", preferenceTypes);

    return "events";
  }

  @GetMapping("/events/category/{categoryName}")
  public String showEventsByCategory(@PathVariable String categoryName, Model model) {

    List<Event> events = eventsService.getAllEventsByCategory(categoryName);
    logger.info("Events by this category are: " + events.size());

    List<Category> categories = categoriesService.getAllCategories();

    Set<EventPreferenceType> preferences = EnumSet.allOf(EventPreferenceType.class);
    List<EventPreferenceType> preferenceTypes = new ArrayList<>(preferences);

    model.addAttribute("events", events);
    model.addAttribute("categories", categories);
    model.addAttribute("eventsCategory", categoryName);
    model.addAttribute("eventPreferenceTypes", preferenceTypes);


    return "events";
  }

  @GetMapping("/events/preference/{preferenceName}")
  public String showEventsByPreference(@PathVariable String preferenceName, Model model) {

    LocalDateTime currentDateTime = LocalDateTime.now();
    logger.info("Locale date is: " + currentDateTime);
    List<Event> events = eventsService.getAllEventsByPreference(preferenceName, currentDateTime);
//
//    logger.info("Events by this category are: " + events.size());
//
    List<Category> categories = categoriesService.getAllCategories();

    Set<EventPreferenceType> preferences = EnumSet.allOf(EventPreferenceType.class);
    List<EventPreferenceType> preferenceTypes = new ArrayList<>(preferences);


    model.addAttribute("events", events);
    model.addAttribute("categories", categories);
    model.addAttribute("eventPreferenceTypes", preferenceTypes);

//    model.addAttribute("eventsCategory", categoryName);

    return "events";
  }

  @GetMapping("/event-details/{eventId}")
  public String showEventWithDetails(@PathVariable String eventId, Model model) {

    Event event = eventsService.getEventById(Integer.parseInt(eventId));
    Set<Organiser> organisers = event.getOrganisers();
    Set<Category> categories = event.getCategories();

    List<Category> allCategories = categoriesService.getAllCategories();
    Set<EventPreferenceType> allPreferences = EnumSet.allOf(EventPreferenceType.class);
    List<EventPreferenceType> allPreferenceTypes = new ArrayList<>(allPreferences);

    model.addAttribute("event", event);
    model.addAttribute("eventOrganisers", organisers);
    model.addAttribute("eventCategories", categories);

    model.addAttribute("allCategories", allCategories);
    model.addAttribute("allPreferenceTypes", allPreferenceTypes);
    return "event-details";
  }

//  @GetMapping("/create-event")
//  public String showCreateEventForm(Model model) {
//    List<Category> categories = categoriesService.getAllCategories();
//    model.addAttribute("event", new Event());
////    model.addAttribute("category", new Category());
//
//    model.addAttribute("categories", categories);
//
//    return "create-event";
//  }
//
//  @PostMapping("/create-event")
//  public String createNewEvent(@ModelAttribute Event event)
//    throws InvalidObjectException {
//
////    logger.info("Name of category is: " + event.getCategories());
//////
////    Category selectedCategory = categoriesService.getCategoryByName(event.getCategory().getName());
////
////    logger.info("Name of selected category is: " + selectedCategory.getName());
////
////    Set<Category> categories = new HashSet<>();
////    categories.add(selectedCategory);
////
////    event.setCategories(categories);
////
////    categoriesService.createCategory(selectedCategory);
//
//    eventsService.createEvent(event);
//    return "create-event";
//  }


}
