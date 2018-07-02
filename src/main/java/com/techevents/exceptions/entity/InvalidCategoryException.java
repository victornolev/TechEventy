package com.techevents.exceptions.entity;

import java.io.InvalidObjectException;

public class InvalidCategoryException extends InvalidObjectException {
  public InvalidCategoryException(final String message){
    super(message);
  }
}
