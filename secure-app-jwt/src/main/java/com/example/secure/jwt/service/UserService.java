package com.example.secure.jwt.service;

import com.example.secure.jwt.entity.UserEntity;
import com.example.secure.jwt.entity.UserJPARepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserJPARepository userJPARepository;
    private final PasswordEncoder passwordEncoder;

    public List<String> getAllUsers() {
        return userJPARepository.findAll()
                .stream()
                .map(UserEntity::getUserName)
                .toList();
    }

    public void insertUser(UserEntity user) {
        var newUser = UserEntity.builder()
                .userName(user.getUserName())
                .password(passwordEncoder.encode(user.getPassword()))
                .roles(user.getRoles())
                .build();

        userJPARepository.save(newUser);
    }
}
