package com.techevents.controllers;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.techevents.dto.UserDto;
import com.techevents.entities.User;
import com.techevents.services.base.UsersService;
import com.techevents.utils.loggers.base.LoggerProvider;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;

public class LoginController {

  private final UsersService usersService;
  private final LoggerProvider<LoginController> logger;

  public LoginController(UsersService usersService, LoggerProvider<LoginController> logger){
    this.usersService = usersService;
    this.logger = logger;
    this.logger.setClass(LoginController.class);
  }

  @GetMapping("/auth/login.html")
  public String showLoginForm() {
    logger.info("Login page loaded successfully!");

    return "auth/login.html";
  }

}

