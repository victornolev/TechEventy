package com.techevents.services;

import com.techevents.dto.UserDto;
import com.techevents.entities.User;
import com.techevents.exceptions.entity.UserAlreadyExistException;
import com.techevents.repositories.base.GenericRepository;
import com.techevents.services.base.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;

@Service
public class UsersServiceImpl implements UsersService {

  private final GenericRepository<User> usersRepository;
  private final PasswordEncoder passwordEncoder;

  @Autowired
  public UsersServiceImpl(GenericRepository<User> usersRepository,
                          PasswordEncoder passwordEncoder) {
    this.usersRepository = usersRepository;
    this.passwordEncoder = passwordEncoder;
  }


  @Override
  public User getUserByUsername(String username) {
    User user = usersRepository.getAll()
      .stream()
      .filter(usr -> usr.getUsername().equals(username))
      .findFirst()
      .orElse(null);

    return user;
  }

  @Override
  public User create(UserDto userDto) throws UserAlreadyExistException {

    if (usernameExist(userDto.getUsername())) {
      throw new UserAlreadyExistException(
        "There is an account with that username: "
          + userDto.getUsername());
    }

    User user = new User();

    user.setFirstName(userDto.getFirstName());
    user.setLastName(userDto.getLastName());
    user.setEmail(userDto.getEmail());

    user.setUsername(userDto.getUsername());
    user.setPassword(passwordEncoder.encode(userDto.getPassword()));

    return usersRepository.create(user);
  }

  private boolean usernameExist(String username) {
    User user = getUserByUsername(username);
    if (user != null) {
      return true;
    }
    return false;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = getUserByUsername(username);

    return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>());
  }
}
