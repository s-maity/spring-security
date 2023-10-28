package com.example.secure.jwt.controller;

import com.example.secure.jwt.service.JWTService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authenticate")
@AllArgsConstructor
public class AuthenticationController {

    private final JWTService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;


    @PostMapping
    public String authenticate(@RequestBody AuthRequest authRequest){
        return jwtService.generateToken(authRequest,authenticationManager);
    }
}
