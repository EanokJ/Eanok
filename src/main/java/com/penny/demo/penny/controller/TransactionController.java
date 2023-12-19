package com.penny.demo.penny.controller;

import com.penny.demo.penny.serviceimpl.InsightService;
import com.penny.demo.penny.serviceimpl.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/penny")
public class TransactionController {
    @Autowired
    private TransactionService service;

    @Autowired
    private InsightService insightService;
    @GetMapping("/transactions")
    public ResponseEntity<?> getAllTransactions(){
        try {
            return new ResponseEntity<>(service.getAllTransactions(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/insights")
    public ResponseEntity<?> getInsightsDetails(){
        try {
            return new ResponseEntity<>(insightService.getAllInsightsDetails(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
