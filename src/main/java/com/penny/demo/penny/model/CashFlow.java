package com.penny.demo.penny.model;

import lombok.Data;

@Data
public class CashFlow {
    private Months month;
    private double payable;
    private double receivable;
}
