package com.penny.demo.penny.model.insights;

import com.penny.demo.penny.model.Months;
import lombok.Data;

import java.util.List;

@Data
public class MoneyFlows {
    @Data
    public static class MoneyFlow{
        private Months month;
        private double netCash;
        private double cashIn;
        private double expense;
    }
    private double netCashTotal;
    private double cashInTotal;
    private double expenseTotal;
    private List<MoneyFlow> moneyFlow;
}
