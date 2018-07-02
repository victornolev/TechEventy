package com.techevents.config;

import com.techevents.entities.Category;
import com.techevents.entities.Event;
import com.techevents.entities.Organiser;
import com.techevents.entities.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtils {
  static SessionFactory sessionFactory;

  static {
    org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration()
      .configure();

    configuration.addAnnotatedClass(Event.class);
    configuration.addAnnotatedClass(Organiser.class);
    configuration.addAnnotatedClass(Category.class);
    configuration.addAnnotatedClass(User.class);

    StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();

    serviceRegistryBuilder.applySettings(configuration.getProperties());
    StandardServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
  }

  public static SessionFactory getSessionFactory() {
    return sessionFactory;
  }
}
