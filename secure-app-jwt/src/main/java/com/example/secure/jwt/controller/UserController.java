package com.example.secure.jwt.controller;

import com.example.secure.jwt.entity.UserEntity;
import com.example.secure.jwt.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public List<String> getAllUsers() {
        return userService.getAllUsers();
    }


    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void insertUser(@RequestBody UserEntity user) {
        userService.insertUser(user);
    }
}
