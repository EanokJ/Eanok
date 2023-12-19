package com.penny.demo.penny.model;

import lombok.Data;

import java.util.List;

@Data
public class Budget {
    @Data
    public static class EmployeeExpense{
        private String empName;
        private double travel;
        private double food;
        private double rent;
        private double others;
    }
    private List<EmployeeExpense> employeeExpense;
    private List<Expenses> expenseChart;
    private List<Expenses> expenseCategory;
}
