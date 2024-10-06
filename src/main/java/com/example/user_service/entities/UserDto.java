package com.example.user_service.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.util.List;


@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {


    @JsonProperty("user_id")
    private String userId;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    @JsonProperty("phone_number")
    private Long phoneNumber;
    @JsonProperty("email")
    private String email;

    public User transformToUser(UserDto userdto,Long id){
        User user=User.builder().id(id).username(userdto.getFirstName()+userdto.getLastName())
                .email(userdto.getEmail())
                .userId(userdto.getUserId())
                .phoneNumber(userdto.getPhoneNumber())
                .firstName(userdto.getFirstName())
                .lastName(userdto.getLastName()).userId(userdto.getUserId()).build();
        return user;
    }
    public static UserDto transformToUserdto(User user){
        UserDto userDto=new UserDto();
        userDto.setEmail(user.getEmail());
        userDto.setUserId(user.getUserId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setPhoneNumber(user.getPhoneNumber());
        return userDto;
    }


}
