package com.penny.demo.penny.controller;

import com.penny.demo.penny.serviceimpl.DashboardService;
import com.penny.demo.penny.serviceimpl.PayService;
import com.penny.demo.penny.serviceimpl.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/penny")
public class DashboardController {
    @Autowired
    DashboardService dashboardService;
    @Autowired
    private PayService service;
    @Autowired
    private VendorService vendorService;
    @GetMapping("/dashboard")
    public ResponseEntity<?> getDashboardDetails(){
        try{
            return new ResponseEntity<>(dashboardService.getDashboardDetails(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Error while getting dashboard details :"+e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get_expenses/{months}")
    public ResponseEntity<?> getExpenses(@PathVariable String months){
        try{
            return new ResponseEntity<>(dashboardService.getExpenses(Integer.parseInt(months)), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Error while getting expenses :"+e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/pay/{state}")
    public ResponseEntity<?> getPayInvoice(@PathVariable String state){
        try {
            return new ResponseEntity<>(service.getInvoiceByState(state), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/vendors")
    public ResponseEntity<?> getVendorsDetails(){
        try {
            return new ResponseEntity<>(vendorService.getVendorsDetails(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/vendor")
    public ResponseEntity<?> getVendorDetails(){
        try {
            return new ResponseEntity<>(vendorService.getVendorDetails(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
