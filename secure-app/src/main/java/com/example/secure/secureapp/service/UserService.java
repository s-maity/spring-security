package com.example.secure.secureapp.service;

import com.example.secure.secureapp.entity.UserEntity;
import com.example.secure.secureapp.entity.UserJPARepository;
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
