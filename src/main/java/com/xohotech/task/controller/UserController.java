package com.xohotech.task.controller;

import com.xohotech.task.core.ResourceAlreadyExistsException;
import com.xohotech.task.model.User;
import com.xohotech.task.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/user")
    public Boolean create(@RequestBody User user) {
        if (userRepository.existsByUsername(user.getUsername())){
            throw new ResourceAlreadyExistsException();
        }
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        userRepository.save(user);
        return true;
    }

}
