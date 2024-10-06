package com.example.user_service.consumer;

import com.example.user_service.service.UserService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import com.example.user_service.entities.UserDto;
import com.example.user_service.repository.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class AuthServiceConsumer {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserService userService;

    @KafkaListener(topics = "userDetails", groupId = "userinfo-consumer-group")
    public void listen(UserDto eventData) {
        System.out.println("I am in conusmer");
        try {

            System.out.println(eventData);
            userService.createOrUpdate(eventData);
            System.out.println("Hello");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
