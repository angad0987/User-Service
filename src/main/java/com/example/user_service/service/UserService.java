package com.example.user_service.service;

import com.example.user_service.entities.User;
import com.example.user_service.entities.UserDto;
import com.example.user_service.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Supplier;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;




    public void saveUser(UserDto userdto){
        int id= new Random().nextInt(9999)+1000;
        User user=User.builder().id(Long.valueOf(id)).username(userdto.getFirstName()+userdto.getLastName())
                .email(userdto.getEmail())
                .phoneNumber(userdto.getPhoneNumber())
                .firstName(userdto.getFirstName())
                .lastName(userdto.getLastName()).build();

        this.userRepo.save(user);
    }
    public UserDto createOrUpdate(UserDto userDto){
        Function<User,User> updateUser= user -> {
            //update logic here
            user.setEmail(userDto.getEmail());
            user.setId(user.getId());
            user.setUsername(userDto.getFirstName()+ userDto.getLastName());
            user.setPhoneNumber(userDto.getPhoneNumber());
            user.setFirstName(userDto.getFirstName());
            user.setLastName(userDto.getLastName());
          return this.userRepo.save(user);
        };
        Supplier<User> createUser=() -> {
            int id= new Random().nextInt(9999)+1000;
            return this.userRepo.save(userDto.transformToUser(userDto, (long) id));
        };

        User user=this.userRepo.findById(userDto.getUserId()).map(updateUser).orElseGet(createUser);
        return userDto;
    }

    public UserDto getUser(String userid) throws Exception {
        User user=this.userRepo.findByUserId(userid);
        System.out.println(userid);
        if(user==null){
            throw new Exception("user not found exception");
        }
        return UserDto.transformToUserdto(user);
    }
}
