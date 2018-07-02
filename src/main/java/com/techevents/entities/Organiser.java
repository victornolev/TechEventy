package com.techevents.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.techevents.entities.base.ModelEntity;
import javassist.CodeConverter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.ManyToAny;
import org.springframework.boot.autoconfigure.condition.ConditionalOnCloudPlatform;

import javax.persistence.*;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Entity
@Table(name = "organisers")
public class Organiser implements ModelEntity {
  private int id;
  private String name;
  private String description;
  private String siteLink;
  private String imageName;


  private List<Event> events;

  public Organiser() {

  }

  public Organiser(String name) {
    this(0, name);
  }

  public Organiser(int id, String name) {
    setId(id);
    setName(name);

    setEvents(new ArrayList<>());
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Column(name = "name", nullable = false, length = 40)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Column(name = "description")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  @Column(name = "site_link")
  public String getSiteLink() {
    return siteLink;
  }

  public void setSiteLink(String siteLink) {
    this.siteLink = siteLink;
  }

  @Column(name = "image_name")
  public String getImageName() {
    return imageName;
  }

  public void setImageName(String imageName) {
    this.imageName = imageName;
  }

  // Can not access GetEvents(), SetEvents() without EAGER fetch
  @ManyToMany(mappedBy = "organisers", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
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
    if (!(obj instanceof Organiser)) {
      return false;
    }
    Organiser other = (Organiser) obj;
    if (id != other.id) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return MessageFormat.format(
      "(id = {0}, name = {1}, events = {2})",
      this.getId(),
      this.getName(),
      this.getEvents()
        .stream()
        .map(Event::toString)
        .collect(Collectors.joining(", ")));
  }
}
