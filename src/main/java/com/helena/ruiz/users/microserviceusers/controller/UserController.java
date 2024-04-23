package com.helena.ruiz.users.microserviceusers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.helena.ruiz.users.microserviceusers.model.dto.UserDto;
import com.helena.ruiz.users.microserviceusers.service.impl.UserServiceImpl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
@Tag(name = "users resource")
public class UserController {
  @Autowired
  private final UserServiceImpl userService;

  @PostMapping("/users")
  @Operation(summary = "post in DB a user in the database from body")
  public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
    UserDto userDto2 = userService.createUser(userDto);
    return new ResponseEntity<>(userDto2, HttpStatus.CREATED);
  }

  @GetMapping("/users/{id}")
  @Operation(summary = "get a user with his id")
  public ResponseEntity<UserDto> getById(@PathVariable("id") Long id) {
    try {
      UserDto UserDto = userService.getUserById(id);
      return new ResponseEntity<>(UserDto, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }
  
  @PutMapping("/users/{id}")
  @Operation(summary = "update in DB a user from body")
  public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long id,
  @RequestBody UserDto updatedUser) {
    try {
      UserDto UserDto = userService.updateUser(id, updatedUser);
      if (UserDto != null) {
        return ResponseEntity.ok(UserDto);
      } else {
        return ResponseEntity.notFound().build();
      }
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }
  
  @DeleteMapping("/users/{id}")
  @Operation(summary = "delete in DB a user")
  public ResponseEntity<UserDto> deleteById(@PathVariable("id") Long id) {
    try {
      userService.deleteUser(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
