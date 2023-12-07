package com.penny.demo.penny.controller;
import com.penny.demo.penny.model.Login;
import com.penny.demo.penny.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/penny")
public class LoginController {
    @Autowired
    private LoginService service;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Login request){
        try{
            boolean isUserValid = service.isValidUser(request);
            return new ResponseEntity<>(isUserValid ? "Success" : "Invalid User", isUserValid ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            return new ResponseEntity<>("INVALID LOGIN CREDENTIALS", HttpStatus.BAD_REQUEST);
        }
    }
}
