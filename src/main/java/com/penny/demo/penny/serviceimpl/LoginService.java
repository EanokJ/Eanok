package com.penny.demo.penny.serviceimpl;

import com.penny.demo.penny.entity.User;
import com.penny.demo.penny.model.JwtAuthenticationResponse;
import com.penny.demo.penny.model.Login;
import com.penny.demo.penny.repository.UserRepository;
import com.penny.demo.penny.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class LoginService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtService jwtService;
    public boolean isValidUser(Login credential){
        User user = userRepository.findByUsername(credential.getUsername());
        if(user != null && user.getPassword().equals(credential.getPassword()))
            return true;
        return false;
    }

    public User getProfile(String username){
        return userRepository.findByUsername(username);
    }

    public User getUserDetails(String username){
        User user = userRepository.findByUsername(username);
        return user;
    }

    public JwtAuthenticationResponse loginUser(Login request){
        authenticationManager.
                authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        var user = userRepository.findByUsername(request.getUsername());
        JwtAuthenticationResponse jwtAuthenticationResponse = new JwtAuthenticationResponse();
        jwtAuthenticationResponse.setToken(jwtService.generateToken(user));
        jwtAuthenticationResponse.setRefreshToken(jwtService.generateRefreshToken(new HashMap<>(), user));
        return jwtAuthenticationResponse;
    }
}
