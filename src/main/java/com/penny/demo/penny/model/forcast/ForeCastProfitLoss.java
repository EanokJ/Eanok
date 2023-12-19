package com.penny.demo.penny.model.forcast;

import com.penny.demo.penny.model.Months;
import lombok.Data;

import java.util.List;

@Data
public class ForeCastProfitLoss {
    private NetIncome netIncome;
    private ExpenseByDepartment expenseByDepartment;
    private List<NetIncomeTrend> netIncomeTrends;
    private List<ExpenseTrend> expenseTrends;
    @Data
    public static class NetIncome{
        private double revenues;
        private double interestIncome;
        private double donations;
        private double total;
    }
    @Data
    public static class ExpenseByDepartment{
        private double travel;
        private double rent;
        private double others;
        private double total;
    }
    @Data
    public static class NetIncomeTrend{
        private Months month;
        private double amount;
    }
    @Data
    public static class ExpenseTrend{
        private Months month;
        private double amount;
    }
}
