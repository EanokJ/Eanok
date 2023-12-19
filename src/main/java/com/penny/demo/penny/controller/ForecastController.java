package com.penny.demo.penny.controller;

import com.penny.demo.penny.serviceimpl.BudgetService;
import com.penny.demo.penny.serviceimpl.ForecastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/penny")
public class ForecastController {
    @Autowired
    private ForecastService forecastService;

    @Autowired
    private BudgetService budgetService;

    @GetMapping("/forecast")
    public ResponseEntity<?> getForecast(){
        try{
            return new ResponseEntity<>(forecastService.getForecastDetails(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/forecast/revenue")
    public ResponseEntity<?> getForecastRevenue(){
        try{
            return new ResponseEntity<>(forecastService.getForecastRevenue(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/forecast/profit_loss")
    public ResponseEntity<?> getProfitAndLoss(){
        try{
            return new ResponseEntity<>(forecastService.getProfileAndLoss(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/budget")
    public ResponseEntity<?> getBudget(){
        try{
            return new ResponseEntity<>(budgetService.getBudgetDetails(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
