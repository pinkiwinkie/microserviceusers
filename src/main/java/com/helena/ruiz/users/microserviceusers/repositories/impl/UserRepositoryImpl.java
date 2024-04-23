package com.helena.ruiz.users.microserviceusers.repositories.impl;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.helena.ruiz.users.microserviceusers.model.UserModel;
import com.helena.ruiz.users.microserviceusers.model.dto.UserDto;
import com.helena.ruiz.users.microserviceusers.repositories.IUserRepository;
import com.helena.ruiz.users.microserviceusers.repositories.dao.IUserDao;
import com.helena.ruiz.users.microserviceusers.utils.ModelMapper;

@Repository
public class UserRepositoryImpl implements IUserRepository {
  @Autowired
  public IUserDao iUserDao;

  @Override
  public UserDto getById(Long id) {
    UserModel product = iUserDao.findById(id)
        .orElseThrow(() -> new NoSuchElementException("User does not exist"));
    return ModelMapper.convertToUserDto(product);
  }

  @Override
  public boolean deleteById(Long id) {
    if (iUserDao.existsById(id)) {
      iUserDao.deleteById(id);
      return true;
    } else {
      return false;
    }
  }

  @Override
  public UserDto createUser(UserDto userDto) {
    UserModel userModel = ModelMapper.convertToUserModel(userDto);
    userModel = iUserDao.save(userModel);
    UserDto UserDto2 = ModelMapper.convertToUserDto(userModel);
    return UserDto2;
  }

  @Override
  public UserDto updateUser(UserDto userDto) {
    if (!iUserDao.existsById(userDto.getId())) {
      throw new NoSuchElementException("User does not exist");
    }

    UserModel userModel = ModelMapper.convertToUserModel(userDto);
    userModel = iUserDao.save(userModel);
    return ModelMapper.convertToUserDto(userModel);
  }

}
