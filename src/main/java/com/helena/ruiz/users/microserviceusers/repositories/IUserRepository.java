package com.helena.ruiz.users.microserviceusers.repositories;

import com.helena.ruiz.users.microserviceusers.model.dto.UserDto;

public interface IUserRepository {
  public UserDto getById(Long id);

  public boolean deleteById(Long id);

  public UserDto createUser(UserDto userDto);

  public UserDto updateUser(UserDto userDto);
}
