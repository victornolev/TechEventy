package com.techevents.controllers.exceptionHandlers;

import com.techevents.exceptions.entity.InvalidEventException;
import com.techevents.exceptions.entity.UserAlreadyExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class GlobalControllerExceptionHandler extends ResponseEntityExceptionHandler {

  @Autowired
  private MessageSource messages;

  public GlobalControllerExceptionHandler() {
    super();
  }

    @ExceptionHandler(InvalidEventException.class)
    public ModelAndView invalidEventException(){
    logger.info("InvalidEventException is thrown");
    logger.info("Returning error message to the user");
      return new ModelAndView("redirect:/create-event", "invalidEventData", true);

    }

  // Client Error 409
//  @ExceptionHandler({ UserAlreadyExistException.class })
//  public ResponseEntity<Object> handleUserAlreadyExist(final RuntimeException ex, final WebRequest request) {
//    logger.error("409 Status Code", ex);
//    final GenericResponse bodyOfResponse = new GenericResponse(messages.getMessage("Account exists! Please choose different username!", null, request.getLocale()), "UserAlreadyExist");
//    return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.CONFLICT, request);
//  }

    @ExceptionHandler(Exception.class)
    public String genericException(Model model, Exception e) throws Exception {
        if(AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null){
            throw e;
        }
        model.addAttribute("view", "error/500");

        return "error-layout";

    }
}
