package com.techevents.validation;

import com.techevents.entities.Category;

import com.techevents.validation.base.Validator;

public class CategoriesValidator implements Validator<Category> {
  private static final int MIN_NAME_LENGTH = 4;
  private static final int MAX_NAME_LENGTH = 200;


  @Override
  public boolean isValid(Category category) {
    return category != null &&
      isNameValid(category.getName());
  }

  private boolean isNameValid(String name) {
    return name != null &&
      name.length() >= MIN_NAME_LENGTH &&
      name.length() <= MAX_NAME_LENGTH;
  }
}
