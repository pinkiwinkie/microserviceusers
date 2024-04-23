package com.helena.ruiz.users.microserviceusers.model.dto;

public class UserDto {
  private Long id;
  private String name;
  private String email;
  private String pwd;
  
  public UserDto() {
  }

  public UserDto(Long id, String name, String email, String pwd) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.pwd = pwd;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPwd() {
    return pwd;
  }

  public void setPwd(String pwd) {
    this.pwd = pwd;
  }
}
