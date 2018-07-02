package com.techevents.entities.forms;

import com.techevents.entities.Category;
import com.techevents.entities.Event;

import java.util.Calendar;

public class AddEventForm {
  private Event event;

  private Category category;

  public Event getEvent() {
    return event;
  }

  public void setEvent(Event event) {
    this.event = event;
  }

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }
}
