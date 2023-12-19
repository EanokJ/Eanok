package com.penny.demo.penny.model.insights;

import com.penny.demo.penny.model.Months;
import lombok.Data;

import java.util.List;

@Data
public class NetCashFlow {
    @Data
    public static class CashFLow{
        private Months month;
        private double cash;
    }
    private double total;
    private List<CashFLow> cashFLow;
}
