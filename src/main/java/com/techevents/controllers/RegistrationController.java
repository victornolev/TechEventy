package com.techevents.controllers;

import com.techevents.dto.UserDto;
import com.techevents.entities.User;
import com.techevents.exceptions.entity.UserAlreadyExistException;
import com.techevents.services.base.UsersService;
import com.techevents.utils.loggers.base.LoggerProvider;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class RegistrationController {

  private final UsersService usersService;
  private final LoggerProvider<RegistrationController> logger;

  public RegistrationController(UsersService usersService, LoggerProvider<RegistrationController> logger) {
    this.usersService = usersService;
    this.logger = logger;
    this.logger.setClass(RegistrationController.class);
  }

  @GetMapping("/auth/register")
  public String showRegistrationForm(WebRequest request, Model model) {

    UserDto userDto = new UserDto();
    model.addAttribute("user", userDto);
    return "auth/register";
  }

  @PostMapping("/auth/register")
  public ModelAndView registerUserAccount(@ModelAttribute("user") @Valid UserDto accountDto,
                                          BindingResult result, WebRequest request,
                                          Errors errors) {
    logger.info("Registering user account with information: [%s]" + accountDto);

    User registered = null;

    if (!result.hasErrors()) {
      registered = createUserAccount(accountDto, result);
      }
    else {
      return new ModelAndView("/auth/register", "wrongInput", true);
    }
    if (registered == null) {
      logger.info("Registered is null!");
      return new ModelAndView("/auth/register", "userExist", true);
//      result.rejectValue("username", "Account exists! Please choose different username!");
    }

    return new ModelAndView("redirect:/auth/login.html", "user", accountDto);
  }

  private User createUserAccount(UserDto accountDto, BindingResult result) {
/*    ModelMapper modelMapper = new ModelMapper();
    User user = modelMapper.map(accountDto, User.class);*/
    User registerUser = null;
    try {
      registerUser = usersService.create(accountDto);
    } catch (UserAlreadyExistException e) {
      return null;
    }
    return registerUser;
  }
}