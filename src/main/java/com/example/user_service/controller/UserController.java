package com.example.user_service.controller;


import com.example.user_service.entities.UserDto;
import com.example.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/user/v1/createUpdate")
    public ResponseEntity<UserDto> createUpdateUser(@RequestBody UserDto userDto){
        try{
            UserDto user=this.userService.createOrUpdate(userDto);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/user/v1/getUser/{userid}")
    public ResponseEntity<UserDto> getUser(@PathVariable String userid){
        try{
            UserDto user=this.userService.getUser(userid);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
