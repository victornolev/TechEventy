package com.techevents.validation;

import com.techevents.entities.Organiser;
import com.techevents.validation.base.Validator;

public class OrganiserValidator implements Validator<Organiser> {
  private static final int MIN_NAME_LENGTH = 4;
  private static final int MIN_DESCRIPTION_LENGTH = 7;
  private static final int MIN_SITE_LINK_LENGTH = 6;
  private static final int MIN_IMAGE_NAME_LENGTH = 5;

  private static final int MAX_NAME_LENGTH = 150;
  private static final int MAX_DESCRIPTION_LENGTH = 50000;
  private static final int MAX_SITE_LINK_LENGTH = 600;
  private static final int MAX_IMAGE_NAME_LENGTH = 100;

  @Override
  public boolean isValid(Organiser organiser) {
    return organiser != null &&
      isNameValid(organiser.getName()) &&
      isDescriptionValid(organiser.getDescription()) &&
      isSiteLinkValid(organiser.getSiteLink()) &&
      isImageNameValid(organiser.getImageName());
  }

  private boolean isNameValid(String name) {
    return name != null &&
      name.length() >= MIN_NAME_LENGTH &&
      name.length() <= MAX_NAME_LENGTH;
  }

  private boolean isDescriptionValid(String description) {
    return description != null &&
      description.length() >= MIN_NAME_LENGTH &&
      description.length() <= MAX_NAME_LENGTH;
  }

  private boolean isSiteLinkValid(String siteLink) {
    return siteLink != null &&
      siteLink.length() >= MIN_NAME_LENGTH &&
      siteLink.length() <= MAX_NAME_LENGTH;
  }

  private boolean isImageNameValid(String imageName) {
    return imageName!= null &&
      imageName.length() >= MIN_NAME_LENGTH &&
      imageName.length() <= MAX_NAME_LENGTH;
  }
}
