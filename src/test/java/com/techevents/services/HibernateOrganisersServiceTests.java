package com.techevents.services;

import com.techevents.entities.Event;
import com.techevents.entities.Organiser;
import com.techevents.repositories.base.GenericRepository;
import com.techevents.services.OrganisersServiceImpl;
import com.techevents.validation.base.Validator;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class HibernateOrganisersServiceTests {

  @Test
  public void getAllOrganisers_whenOrganisersAreAvailable_expectTheOrganisers(){

    // Arrange
    List<Organiser> organisers = Arrays.asList(
      new Organiser("Apple"),
      new Organiser("Samsung")
    );

    GenericRepository<Organiser> repo = new GenericRepository<Organiser>() {
      @Override
      public List<Organiser> getAll() {
        return organisers;
      }

      @Override
      public Organiser getById(int id) {
        return null;
      }

      @Override
      public Organiser create(Organiser entity) {
        return null;
      }
    };

    Validator<Organiser> validator = new Validator<Organiser>() {
      @Override
      public boolean isValid(Organiser object) {
        return true;
      }
    };

    OrganisersServiceImpl service = new OrganisersServiceImpl(repo, validator);

    // Act
    List<Organiser> actualOrganisers = service.getAllOrganisers();

    // Asserts
    Assert.assertArrayEquals(actualOrganisers.toArray(), organisers.toArray());
  }

}
