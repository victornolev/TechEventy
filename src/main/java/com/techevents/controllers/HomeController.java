package com.techevents.controllers;

import com.techevents.utils.loggers.base.LoggerProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

  private final LoggerProvider<HomeController> logger;

  public HomeController(LoggerProvider<HomeController> logger){

    this.logger = logger;
    this.logger.setClass(HomeController.class);
  }

  @GetMapping("/home")
  public String showHomePage(){
    logger.info("Home page loaded successfully!");

    return "home";
  }
}

