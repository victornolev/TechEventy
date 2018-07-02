package com.techevents.validation;

import com.techevents.entities.Event;
import com.techevents.validation.base.Validator;

public class EventValidator implements Validator<Event> {
  private static final int MIN_NAME_LENGTH = 4;
  private static final int MIN_DESCRIPTION_LENGTH = 7;
  private static final int MIN_LOCATION_LENGTH = 5;
  private static final int MIN_ENTRANCE_FEE = 0;
  private static final int MIN_URL_OF_EVENT_LENGTH = 6;
  private static final int MIN_IMAGE_PATH_LENGTH = 5;

  private static final int MAX_NAME_LENGTH = 200;
  private static final int MAX_DESCRIPTION_LENGTH = 50000;
  private static final int MAX_LOCATION_LENGTH = 300;
  private static final int MAX_ENTRANCE_FEE = 9999999;
  private static final int MAX_URL_OF_EVENT_LENGTH = 600;
  private static final int MAX_IMAGE_PATH_LENGTH = 100;

  @Override
  public boolean isValid(Event event) {
    return event != null &&
      isNameValid(event.getName()) &&
      isDescriptionValid(event.getDescription()) &&
      isPlaceValid(event.getLocation()) &&
      isEntranceValid(event.getEntranceFee()) &&
      isUrlOfEventValid(event.getUrlOfEvent());
//      isImagePathValid(event.getImagePath());
  }

  private boolean isNameValid(String name) {
    return name != null &&
      name.length() >= MIN_NAME_LENGTH &&
      name.length() <= MAX_NAME_LENGTH;
  }

  private boolean isDescriptionValid(String description) {
    return description != null &&
      description.length() >= MIN_DESCRIPTION_LENGTH &&
      description.length() <= MAX_DESCRIPTION_LENGTH;
  }

  private boolean isPlaceValid(String location) {
    return location != null &&
      location.length() >= MIN_LOCATION_LENGTH &&
      location.length() <= MAX_LOCATION_LENGTH;
  }

  private boolean isEntranceValid(Double entranceFee) {
    return entranceFee >= MIN_ENTRANCE_FEE &&
      entranceFee <= MAX_ENTRANCE_FEE;
  }

  private boolean isUrlOfEventValid(String urlOfEvent) {
    return urlOfEvent != null &&
      urlOfEvent.length() >= MIN_URL_OF_EVENT_LENGTH &&
      urlOfEvent.length() <= MAX_URL_OF_EVENT_LENGTH;
  }

//  private boolean isImagePathValid(String imagePath) {
//    return imagePath != null &&
//      imagePath.length() >= MIN_IMAGE_PATH_LENGTH &&
//      imagePath.length() <= MAX_IMAGE_PATH_LENGTH;
//  }

}
