package com.example.secure.secureapp.securityconfig;

import com.example.secure.secureapp.entity.UserEntity;
import com.example.secure.secureapp.entity.UserJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserJPARepository userJPARepository;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userJPARepository.findByUserName(username)
                .map(this::encodePasswordForDefaultUser)
                .map(CustomUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("Authentication failed"));

    }

    private UserEntity encodePasswordForDefaultUser(UserEntity user) {
        if (user.getUserName()
                .equals("admin")) {
            user.setPassword(encoder.encode(user.getPassword()));
        }
        return user;
    }
}
