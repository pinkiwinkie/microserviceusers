package com.helena.ruiz.users.microserviceusers.repositories.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.helena.ruiz.users.microserviceusers.model.UserModel;

public interface IUserDao extends JpaRepository<UserModel, Long>{
  
}
