package com.penny.demo.penny.service;

import com.penny.demo.penny.entity.User;
import com.penny.demo.penny.model.SignUp;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserValidationService {
    public UserDetailsService userDetailsService();

    public User signupUser(SignUp user);

    public List<String> getUsernamesLimitedTo(int limit);
}
