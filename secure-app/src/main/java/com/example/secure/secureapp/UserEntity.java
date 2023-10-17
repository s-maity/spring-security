package com.example.secure.secureapp;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "t_user")
@Data
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String userName;
    private String password;
    private String role;
}
