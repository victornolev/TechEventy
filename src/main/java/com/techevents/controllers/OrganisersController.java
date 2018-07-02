package com.techevents.controllers;

import com.techevents.entities.Event;
import com.techevents.entities.Organiser;
import com.techevents.entities.base.ModelEntity;
import com.techevents.services.base.EventsService;
import com.techevents.services.base.OrganisersService;
import org.hibernate.Hibernate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
public class OrganisersController {

  private final OrganisersService organisersService;

  private final EventsService eventsService;


  public OrganisersController(OrganisersService organisersService, EventsService eventsService) {
    this.organisersService = organisersService;
    this.eventsService = eventsService;
  }

  @GetMapping("/organisers")
  public String allOrganisers(Model model) {
    List<Organiser> organisers = organisersService.getAllOrganisers();
    model.addAttribute("organisers", organisers);
    return "organisers";
  }

  @GetMapping("/organiser-details/{id}")
  public String detailedOrganiser(@PathVariable String id, Model model) {
    Organiser organiser = organisersService.getOrganiserById(Integer.parseInt(id));

    // SOLVED - failed to lazily initialize a collection of role: com.techevents.entities.Organiser.events, could not initialize proxy - no Session

    List<Event> eventsByOrganiser = organiser.getEvents();
//    List<Event> eventsByOrganiser = eventsService.getEventsByOrganiser(organiser.getName());

    model.addAttribute("organiser", organiser);
    model.addAttribute("eventsByOrganiser", eventsByOrganiser);

    return "organiser-details";
  }
}
