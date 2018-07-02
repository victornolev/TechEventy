package com.techevents.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.techevents.entities.base.ModelEntity;
import org.hibernate.annotations.ManyToAny;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.MessageFormat;
import java.text.ParsePosition;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "events")
public class Event implements ModelEntity {

  private int id;
  private String name;
  private String description;

  @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
  private LocalDateTime dateTime;
  private String location;
  private Double entranceFee;
  private String urlOfEvent;
  private String imagePath;

  private Set<Organiser> organisers;

  private Set<Category> categories;

  public Event() {

  }

  public Event(String name) {
    this(0, name);
  }

  public Event(int id, String name) {
    setId(id);
    setName(name);

    setOrganisers(new HashSet<>());
    setCategories(new HashSet<>());
  }

  public Event(int id, String name, String description, LocalDateTime dateTime,
               String location, Double entranceFee, String urlOfEvent, String imagePath) {
    setId(id);
    setName(name);
    setDescription(description);
    setDateTime(dateTime);
    setLocation(location);
    setEntranceFee(entranceFee);
    setUrlOfEvent(urlOfEvent);
    setImagePath(imagePath);

    setOrganisers(new HashSet<>());
    setCategories(new HashSet<>());
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


  @Column(name = "name", nullable = false)
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

  @Column(name = "date_time")
  public LocalDateTime getDateTime() {
    return dateTime;
  }

  public void setDateTime(LocalDateTime dateTime) {
    this.dateTime = dateTime;
  }

  @Column(name = "location")
  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  @Column(name = "entrance_fee")
  public Double getEntranceFee() {
    return entranceFee;
  }

  public void setEntranceFee(Double entranceFee) {
    this.entranceFee = entranceFee;
  }

  @Column(name = "url_of_event")
  public String getUrlOfEvent() {
    return urlOfEvent;
  }

  public void setUrlOfEvent(String urlOfEvent) {
    this.urlOfEvent = urlOfEvent;
  }

  @Column(name = "image_path")
  public String getImagePath() {
    return imagePath;
  }

  public void setImagePath(String imagePath) {
    this.imagePath = imagePath;
  }

  // decide if it necessary to use this CascadeType
  @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JoinTable(
    name = "events_organisers",
    joinColumns = {@JoinColumn(name = "events_id")},
    inverseJoinColumns = {@JoinColumn(name = "organisers_id")}
  )
  public Set<Organiser> getOrganisers() {
    return organisers;
  }

  public void setOrganisers(Set<Organiser> organisers) {
    this.organisers = organisers;
  }

  // CascadeType.PERSIST - better when deleting some objects with relations?
  @ManyToMany(cascade = {CascadeType.PERSIST}, fetch = FetchType.EAGER)
  @JoinTable(
    name = "events_categories",
    joinColumns = {@JoinColumn(name = "event_id")},
    inverseJoinColumns = {@JoinColumn(name = "category_id")}
  )
  public Set<Category> getCategories() {
    return categories;
  }

  public void setCategories(Set<Category> categories) {
    this.categories = categories;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (int) (id ^ (id >>> 32));
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (!(obj instanceof Event)) {
      return false;
    }
    Event other = (Event) obj;
    if (id != other.id) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return MessageFormat.format(
      "Event: [id={0}, name={1}, description={2}, dateTime={3}, " +
        "location={4}, entranceFee={5}, urlOfEvent={6}, imagePath={7}]",
      getId(),
      getName(),
      getDescription(),
      getDateTime(),
      getLocation(),
      getEntranceFee(),
      getUrlOfEvent(),
      getImagePath());
//    ,
//      getOrganisers()
//        .stream()
//        .map(Organiser::toString)
//        .collect(Collectors.joining(", "))
  }
}