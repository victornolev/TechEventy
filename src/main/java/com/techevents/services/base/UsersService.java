package com.techevents.services.base;
import com.techevents.dto.UserDto;
import com.techevents.entities.User;
import com.techevents.exceptions.entity.UserAlreadyExistException;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UsersService extends UserDetailsService {
  User getUserByUsername(String username);


  User create(UserDto user);
}
