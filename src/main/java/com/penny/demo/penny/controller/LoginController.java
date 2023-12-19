package com.penny.demo.penny.controller;

import com.penny.demo.penny.model.Login;
import com.penny.demo.penny.model.SignUp;
import com.penny.demo.penny.service.UserValidationService;
import com.penny.demo.penny.serviceimpl.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/penny")
public class LoginController {
    @Autowired
    private LoginService service;

    @Autowired
    private UserValidationService userValidationService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Login request){
       try{
           return new ResponseEntity<>(service.loginUser(request), HttpStatus.OK);
       }catch (Exception e){
            return new ResponseEntity<>("INVALID USERNAME OR PASSWORD", HttpStatus.BAD_REQUEST);
       }
    }

    @GetMapping("/profile")
    public ResponseEntity<?> getProfile(@RequestParam("username") String username){
        try{
            return new ResponseEntity<>(service.getProfile(username), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignUp user){
        try{
            return  new ResponseEntity<>(userValidationService.signupUser(user), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>("INVALID LOGIN CREDENTIALS", HttpStatus.BAD_REQUEST);
        }
    }
}
