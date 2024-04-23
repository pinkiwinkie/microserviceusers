package com.helena.ruiz.users.microserviceusers.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.helena.ruiz.users.microserviceusers.model.UserModel;
import com.helena.ruiz.users.microserviceusers.model.dto.UserDto;

public class ModelMapper {
  private static final ObjectMapper objectMapper = new ObjectMapper();

  public static UserDto convertToUserDto(UserModel userModel) {
    return objectMapper.convertValue(userModel, UserDto.class);
  }

  public static UserModel convertToUserModel(UserDto userDto) {
    return objectMapper.convertValue(userDto, UserModel.class);
  }
}
