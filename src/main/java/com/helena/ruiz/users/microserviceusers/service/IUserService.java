package com.helena.ruiz.users.microserviceusers.service;

import com.helena.ruiz.users.microserviceusers.model.dto.UserDto;

public interface IUserService {
  UserDto createUser(UserDto userDto);

  UserDto getUserById(Long id);

  UserDto updateUser(Long id, UserDto userDto);

  boolean deleteUser(Long id);
  
}
