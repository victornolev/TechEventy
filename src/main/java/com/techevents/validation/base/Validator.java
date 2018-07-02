package com.techevents.validation.base;

public interface Validator<T> {
  boolean isValid(T object);
}
