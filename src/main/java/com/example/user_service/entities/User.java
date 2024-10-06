package com.example.user_service.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Setter
public class User {




    private Long id;

    @Id
    private String userId;

    private String username;
    private String firstName;
    private String lastName;
    private Long phoneNumber;
    private String email;
}
