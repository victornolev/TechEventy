package com.techevents.dto;

import com.techevents.validation.user.PasswordMatches;
import com.techevents.validation.user.ValidEmail;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@PasswordMatches // Custom validation
public class UserDto {
  @NotNull
  @Size(min = 3, message = "{Size.userDto.firstName}")
  private String firstName;

  @NotNull
  @Size(min = 3, message = "{Size.userDto.lastName}")
  private String lastName;

  @NotNull
  @Size(min = 3)
  private String username;

  //  @ValidPassword // Custom validation
  @NotNull
  @Size(min = 8)
  private String password;

  @NotNull
  @Size(min = 8)
  private String matchingPassword;


  @ValidEmail // Custom validation
  @NotNull
  @Size(min = 3, message = "{Size.userDto.email}")
  private String email;

  // SOLVED
  // Q: There is no constructor - is it a problem? :D;
  // A: The default empty constructor is invoked and we do not need to manually create new UserDto() instance - it is created via thymeleaf form in register.html

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(final String email) {
    this.email = email;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(final String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(final String lastName) {
    this.lastName = lastName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(final String password) {
    this.password = password;
  }

  public String getMatchingPassword() {
    return matchingPassword;
  }

  public void setMatchingPassword(final String matchingPassword) {
    this.matchingPassword = matchingPassword;
  }


  @Override
  public String toString() {
    final StringBuilder builder = new StringBuilder();
    builder.append("UserDto [firstName=").append(firstName).append(", lastName=").append(lastName)
      .append(", username=").append(username)
      .append(", password=").append(password).append(", matchingPassword=").append(matchingPassword).
      append(", email=").append(email)
      .append("]");
    return builder.toString();
  }
}