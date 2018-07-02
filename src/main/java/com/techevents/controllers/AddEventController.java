package com.techevents.controllers;

import com.techevents.entities.Category;
import com.techevents.entities.Event;
import com.techevents.entities.forms.AddEventForm;
import com.techevents.exceptions.entity.InvalidEventException;
import com.techevents.services.base.CategoriesService;
import com.techevents.services.base.EventsService;
import com.techevents.utils.loggers.base.LoggerProvider;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class AddEventController {

  private final EventsService eventsService;

  private final CategoriesService categoriesService;

  private final LoggerProvider<AddEventController> logger;

  public AddEventController(EventsService eventsService, CategoriesService categoriesService,
                            LoggerProvider<AddEventController> logger) {
    this.eventsService = eventsService;
    this.categoriesService = categoriesService;

    this.logger = logger;
    this.logger.setClass(AddEventController.class);
  }

  @GetMapping("/create-event")
  public String showCreateEventForm(@RequestParam(value = "isAddEventFormEmpty", required = false)
                                      String emptyAddEventForm,
                                    @RequestParam(value = "invalidEventData", required = false)
                                      String invalidEventData,
                                    Model model) {

    if (emptyAddEventForm != null) {
      model.addAttribute("isAddEventFormEmpty", true);
    }
    if (invalidEventData != null) {
      model.addAttribute("invalidEventData", true);
    }

    List<Category> categories = categoriesService.getAllCategories();
    logger.info("Number of categories: " + categories.size());

    model.addAttribute("addEventForm", new AddEventForm());
    model.addAttribute("categories", categories);

    return "create-event";
  }

  @PostMapping("/create-event")
  public ModelAndView addNewEvent(@ModelAttribute("addEventForm") AddEventForm addEventForm)
    throws InvalidEventException {

    if (addEventForm == null) {
      logger.info("AddEvent form is null!");
      return new ModelAndView("redirect:/create-event", "isAddEventFormEmpty", true);

    }
    if (addEventForm.getEvent() == null || addEventForm.getCategory().getName().equals("")) {
      logger.info("Some fields of addEventForm are null! Event is: "
        + addEventForm.getEvent() + " Category is: " + addEventForm.getCategory());
      return new ModelAndView("redirect:/create-event", "isAddEventFormEmpty", true);
    }

    logger.info("Selected category for event is: " + addEventForm.getCategory().getName());

    Category selectedCategory = categoriesService.
      getCategoryByName(addEventForm.getCategory().getName());

    logger.info("Founded event's category in Category: " + selectedCategory);
    Set<Category> categories = new HashSet<>();
    categories.add(selectedCategory);

    Event event = addEventForm.getEvent();

    event.setCategories(categories);

//    try {
//      eventsService.createEvent(event);
//    } catch (InvalidEventException e) {
//      return new ModelAndView("redirect:/create-event", "invalidEventData", true);
//    }

    eventsService.createEvent(event);

    return new ModelAndView("redirect:/events");
  }
}
