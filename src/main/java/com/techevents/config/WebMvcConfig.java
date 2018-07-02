package com.techevents.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
//@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {

  @Autowired
  private ApplicationContext applicationContext;

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry
      .addResourceHandler("/static/**")
      .addResourceLocations("/static/");
  }

  @Override
  public void addViewControllers(ViewControllerRegistry registry) {

    registry.addViewController("/home.html").setViewName("home");
    registry.addViewController("/events.html").setViewName("events");
    registry.addViewController("/event-details.html").setViewName("event-details");
    registry.addViewController("/create-event.html").setViewName("create-event");

    registry.addViewController("/organisers.html").setViewName("organisers");
    registry.addViewController("/auth/login.html").setViewName("auth/login");
    registry.addViewController("/auth/register.html").setViewName("auth/register");
  }
}
