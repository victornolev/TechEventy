package com.techevents.exceptions.entity;

public class UserAlreadyExistException extends RuntimeException{
  public UserAlreadyExistException(final String message) {
    super(message);
  }
}
