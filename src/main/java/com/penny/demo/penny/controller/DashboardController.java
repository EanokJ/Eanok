package com.penny.demo.penny.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/penny")
public class DashboardController {

    @GetMapping("/dashboard")
    public ResponseEntity<?> getDashboardDetails(){
        return null;
    }
}
