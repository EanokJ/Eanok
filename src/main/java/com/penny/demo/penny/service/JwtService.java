package com.penny.demo.penny.service;

import com.penny.demo.penny.entity.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Map;

public interface JwtService {

    public String generateToken(UserDetails userDetails);

    public String extractUsername(String token);

    public boolean validateToken(String token, UserDetails userDetails);

    public String generateRefreshToken(Map<String, Object> extraClaims, User user);
}
