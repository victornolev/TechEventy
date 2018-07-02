package com.techevents.exceptions.entity;

import java.io.InvalidObjectException;

public class InvalidOrganiserException extends InvalidObjectException{
  public InvalidOrganiserException(final String message) {
    super(message);
  }
}
