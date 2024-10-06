package com.example.user_service.deserializer;

import javax.print.DocFlavor.BYTE_ARRAY;

import org.apache.kafka.common.serialization.Deserializer;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.user_service.entities.UserDto;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UserInfoDeserializer implements Deserializer<UserDto> {

    @Override
    public void close() {
    }

    @Override
    public UserDto deserialize(String topic, byte[] data) {
        UserDto user = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            //Log the raw JSON data
            String json = new String(data);
            System.out.println("Raw JSON: " + json);
            user = mapper.readValue(data, UserDto.class);
        } catch (Exception e) {
            System.out.println("User cannot be deserialize");
        }
        return user;
    }

}
