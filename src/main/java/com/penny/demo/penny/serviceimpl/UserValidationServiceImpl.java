package com.penny.demo.penny.serviceimpl;

import com.penny.demo.penny.entity.User;
import com.penny.demo.penny.model.SignUp;
import com.penny.demo.penny.repository.UserRepository;
import com.penny.demo.penny.service.UserValidationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserValidationServiceImpl implements UserValidationService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService(){
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                return userRepository.findByUsername(username);
            }
        };
    }

    @Override
    public User signupUser(SignUp request) {
        User user = new User();
        user.setFirstname(request.getFirstname());
        user.setLastname(request.getLastname());
        user.setUsername(request.getUsername());
        user.setMobileNumber(request.getMobileNumber());
        user.setRole(request.getRole());
        user.setPassword(new BCryptPasswordEncoder().encode(request.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public List<String> getUsernamesLimitedTo(int limit) {
        return userRepository.getNames(limit);
    }

}
