package com.penny.demo.penny.controller;

import com.penny.demo.penny.serviceimpl.IntegrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/penny")
public class IntegrationController {

    @Autowired
    private IntegrationService service;

    @GetMapping("/get_integrations")
    public ResponseEntity<?> getIntegrations(){
        try{
            return new ResponseEntity<>(service.getAllIntegrations(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get_networks")
    public ResponseEntity<?> getNetworks(){
        try{
            return new ResponseEntity<>(service.getAllIntegrations(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get_banks")
    public ResponseEntity<?> getBanks(){
        try{
            return new ResponseEntity<>(service.getAllBanks(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
