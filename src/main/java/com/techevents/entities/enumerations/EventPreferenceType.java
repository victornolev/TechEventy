package com.techevents.entities.enumerations;

public enum EventPreferenceType {
  PAST, UPCOMING, THIS_MONTH, NEXT_MONTH;

  @Override
  public String toString() {

    return super.toString().replace('_', ' ').toLowerCase();
  }
}

