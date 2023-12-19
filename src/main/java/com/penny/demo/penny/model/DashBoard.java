package com.penny.demo.penny.model;

import com.penny.demo.penny.entity.Bank;
import com.penny.demo.penny.entity.Notification;
import lombok.Data;

import java.util.List;

@Data
public class DashBoard {
    private double payable;
    private double receivable;
    private double total;
    private List<CashFlow> cashFlow;
    private List<Expenses> expenses;
    private List<Notification> notifications;
    private List<Bank> banks;
}
