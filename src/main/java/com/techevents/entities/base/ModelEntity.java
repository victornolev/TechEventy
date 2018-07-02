package com.techevents.entities.base;

import java.io.Serializable;
import java.util.Set;

public interface ModelEntity<T> extends Serializable {
  int getId();

  void setId(int id);

//  Set<T> getAll();
//
}
