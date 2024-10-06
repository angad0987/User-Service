package com.example.user_service.repository;

import com.example.user_service.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends CrudRepository<User,String> {

    User findByUserId(String userid);

}
