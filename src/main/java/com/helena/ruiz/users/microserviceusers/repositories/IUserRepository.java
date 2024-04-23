package com.helena.ruiz.users.microserviceusers.repositories;

import com.helena.ruiz.users.microserviceusers.model.dto.UserDto;

public interface IUserRepository {
  public UserDto getById(Long id);

  public boolean deleteById(Long id);

  public UserDto createProduct(UserDto userDto);

  public UserDto updateProduct(UserDto userDto);
}
