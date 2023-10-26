package com.example.secure.secureapp.entity;

import com.example.secure.secureapp.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserJPARepository extends JpaRepository<UserEntity, Integer> {

    Optional<UserEntity> findByUserName(String userName);
}
