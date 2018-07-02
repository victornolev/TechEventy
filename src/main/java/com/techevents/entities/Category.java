package com.techevents.entities;

import com.techevents.entities.base.ModelEntity;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "categories")
public class Category implements ModelEntity {

  private int id;
  private String name;

  private List<Event> events;

  public Category() {

  }

  public Category(String name) {
    this(0, name);
  }

  public Category(int id, String name) {
    setId(id);
    setName(name);

    setEvents(new ArrayList<>());
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  @Override
  public int getId() {
    return id;
  }

  @Override
  public void setId(int id) {
    this.id = id;
  }

  @Column(name = "name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @ManyToMany(mappedBy = "categories", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  public List<Event> getEvents() {
    return events;
  }

  public void setEvents(List<Event> events) {
    this.events = events;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (int) (id ^ (id >>> 32));
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (!(obj instanceof Category)) {
      return false;
    }
    Category other = (Category) obj;
    if (id != other.id) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return MessageFormat.format(
      "Category [id = {0}, name = {1}, events = {2}]",
      this.getId(),
      this.getName(),
      this.getEvents()
        .stream()
        .map(Event::toString)
        .collect(Collectors.joining(", ")));
  }
}
