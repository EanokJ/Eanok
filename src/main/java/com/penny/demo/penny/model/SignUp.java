package com.penny.demo.penny.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
public class SignUp {
    private String username;
    private String password;
    private String role;
    private String mobileNumber;
    private String firstname;
    private String lastname;
}
