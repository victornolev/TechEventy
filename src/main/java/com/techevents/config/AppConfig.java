package com.techevents.config;

import com.techevents.entities.Category;
import com.techevents.entities.Event;
import com.techevents.entities.Organiser;
import com.techevents.entities.User;
import com.techevents.repositories.base.GenericRepository;
import com.techevents.repositories.HibernateRepository;
import com.techevents.validation.CategoriesValidator;
import com.techevents.validation.EventValidator;
import com.techevents.validation.OrganiserValidator;
import com.techevents.validation.base.Validator;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
  @Bean
  @Autowired
  GenericRepository<Event> provideEventsGenericRepository(SessionFactory sessionFactory) {
    HibernateRepository<Event> eventsRepo = new HibernateRepository<>(sessionFactory, Event.class);

    return eventsRepo;
  }

  @Bean
  @Autowired
  GenericRepository<Organiser> provideOrganisersGenericRepository(SessionFactory sessionFactory) {
    HibernateRepository<Organiser> organisersRepo = new HibernateRepository<>(sessionFactory, Organiser.class);

    return organisersRepo;
  }

  @Bean
  @Autowired
  GenericRepository<User> provideUsersGenericRepository(SessionFactory sessionFactory) {
    HibernateRepository<User> usersRepo = new HibernateRepository<>(sessionFactory, User.class);

    return usersRepo;
  }

  @Bean
  @Autowired
  GenericRepository<Category> provideCategoriesGenericRepository(SessionFactory sessionFactory) {
    HibernateRepository<Category> categoriesRepo = new HibernateRepository<>(sessionFactory, Category.class);

    return categoriesRepo;
  }

  @Bean
  SessionFactory provideSessionFactory() {
    return HibernateUtils.getSessionFactory();
  }

  @Bean
  Validator<Event> provideEventValidator() {
    return new EventValidator();
  }

  @Bean
  Validator<Organiser> provideOrganiserValidator() {
    return new OrganiserValidator();
  }

  @Bean
  Validator<Category> provideCategoryValidator() {
    return new CategoriesValidator();
  }

}



