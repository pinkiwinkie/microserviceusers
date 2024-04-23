package com.helena.ruiz.users.microserviceusers.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helena.ruiz.users.microserviceusers.model.dto.UserDto;
import com.helena.ruiz.users.microserviceusers.repositories.IUserRepository;
import com.helena.ruiz.users.microserviceusers.service.IUserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements IUserService{

  @Autowired
  private final IUserRepository iRepository;

  @Override
  public UserDto createUser(UserDto userDto) {

    return iRepository.createUser(userDto);
  }

  @Override
  public UserDto getUserById(Long id) {
    return iRepository.getById(id);
  }

  @Override
  public UserDto updateUser(Long id, UserDto userDtoUpdate) {
    UserDto userSearch = iRepository.getById(id);
    if (userSearch != null) {
      userSearch.setName(userDtoUpdate.getName());
      userSearch.setEmail(userDtoUpdate.getEmail());
      userSearch.setPwd(userDtoUpdate.getPwd());

      return iRepository.updateUser(userSearch);
    } else {
      return null;
    }
  }

  @Override
  public boolean deleteUser(Long id) {
    try {
      iRepository.deleteById(id);
      return true;
    } catch (Exception e) {
      return false;
    }
  }
  
}
