package com.techevents.services;

import com.techevents.entities.Organiser;
import com.techevents.exceptions.entity.InvalidOrganiserException;
import com.techevents.repositories.base.GenericRepository;
import com.techevents.services.base.OrganisersService;
import com.techevents.validation.base.Validator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrganisersServiceImpl implements OrganisersService {

  private final GenericRepository<Organiser> organiserRepository;
  private final Validator<Organiser> organiserValidator;

  public OrganisersServiceImpl(GenericRepository<Organiser> organiserRepository, Validator<Organiser> organiserValidator) {
    this.organiserRepository = organiserRepository;
    this.organiserValidator = organiserValidator;
  }

  @Override
  public List<Organiser> getAllOrganisers() {
    return organiserRepository.getAll();
  }

  @Override
  public List<Organiser> getOrganisersByEvent(String eventName) {
    return null;
  }

  @Override
  public Organiser getOrganiserById(int id) {
    return organiserRepository.getById(id);
  }

  @Override
  public List<Organiser> getOrganiserByName(String organiserName) {
    List<Organiser> organisers = organiserRepository.getAll();

    return organisers.stream()
      .filter(organiser -> organiser.getName().contains(organiserName))
      .collect(Collectors.toList());
  }

  @Override
  public void createOrganiser(Organiser organiser) throws InvalidOrganiserException {
    if (!organiserValidator.isValid(organiser)) {
      throw new InvalidOrganiserException("Invalid data for fields of organiser: " + organiser);
    }
    organiserRepository.create(organiser);

  }
}
