package com.techevents.exceptions.entity;

import java.io.InvalidObjectException;

public class InvalidEventException extends InvalidObjectException{
  public InvalidEventException(final String message){
    super(message);
  }
}
