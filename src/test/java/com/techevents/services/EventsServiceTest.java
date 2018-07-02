package com.techevents.services;

import com.techevents.entities.enumerations.EventPreferenceType;
import org.junit.Test;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class EventsServiceTest {
  @Test
  public void getPreference_whenPreferencesAreAvailable_shouldRedurnIt() throws Exception {
    String preferenceName = "this month";
    EventPreferenceType preferenceType = EventPreferenceType.valueOf(preferenceName.replace(' ', '_').toUpperCase());

    System.out.print(preferenceType);

    switch (preferenceType) {
      case PAST:
        break;
      case UPCOMING:
        break;
      case THIS_MONTH:
        break;
      case NEXT_MONTH:
        break;

      default:

    }

    assertEquals(preferenceName, preferenceType.toString());
//
//    Set<EventPreferenceType> preferences = EnumSet.allOf(EventPreferenceType.class);
//    List<EventPreferenceType> preferenceTypes = new ArrayList<>(preferences);
//    for (EventPreferenceType prfr: preferenceTypes){
//      System.out.println(prfr);
//    }

  }

}