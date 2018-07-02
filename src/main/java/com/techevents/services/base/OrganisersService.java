package com.techevents.services.base;

import com.techevents.entities.Event;
import com.techevents.entities.Organiser;
import com.techevents.exceptions.entity.InvalidOrganiserException;

import java.io.InvalidObjectException;
import java.util.List;

public interface OrganisersService {

  List<Organiser> getAllOrganisers();

  List<Organiser> getOrganisersByEvent(String eventName);

  Organiser getOrganiserById(int id);

  List<Organiser> getOrganiserByName(String organiserName);


  void createOrganiser(Organiser organiser) throws InvalidOrganiserException;
}
