package com.example.Lab4.controllers;

import com.example.Lab4.domain.User;
import com.example.Lab4.domain.dto.UserDto;
import com.example.Lab4.repositories.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    final UserRepository userRepository;

    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody UserDto toLogin) {
        Optional<User> userOptional = userRepository.findByName(toLogin.getName());
        if(userOptional.isEmpty()) {
            return ResponseEntity.badRequest().body("Wrong username/password");
        }
        User user = userOptional.get();
        if(!user.getPassword().equals(toLogin.getPassword())) {
            return ResponseEntity.badRequest().body("Wrong username/password");
        }
        return ResponseEntity.ok(user);
    }
}
