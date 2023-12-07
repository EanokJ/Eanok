package com.penny.demo.penny.service;

import com.penny.demo.penny.entity.User;
import com.penny.demo.penny.model.Login;
import com.penny.demo.penny.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {
    @Autowired
    private UserRepository repo;
    @Autowired
    private PasswordEncoder encoder;
    public boolean isValidUser(Login credential){
        Optional<User> user = repo.findByUserName(credential.getUsername());
        if(!user.isEmpty() && encoder.encode(user.get().getPassword()).equals(credential.getPassword()))
            return true;
        return false;
    }
}
