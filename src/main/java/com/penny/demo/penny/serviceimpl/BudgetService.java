package com.penny.demo.penny.serviceimpl;

import com.penny.demo.penny.model.Budget;
import com.penny.demo.penny.model.Expenses;
import com.penny.demo.penny.model.Months;
import com.penny.demo.penny.service.UserValidationService;
import com.penny.demo.penny.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BudgetService {
    @Autowired
    private UserValidationService userValidationService;

    public Budget getBudgetDetails() {
        Budget budget = new Budget();
        List<Budget.EmployeeExpense> employeeExpenseList = new ArrayList<>();
        List<String> employees = userValidationService.getUsernamesLimitedTo(5);
        for (int i = 0; i < employees.size(); i++) {
            Budget.EmployeeExpense employeeExpense = new Budget.EmployeeExpense();
            employeeExpense.setEmpName(employees.get(i));
            employeeExpense.setFood(Utils.getRandomNumberBetween(5000, 10000));
            employeeExpense.setTravel(Utils.getRandomNumberBetween(5000, 10000));
            employeeExpense.setRent(Utils.getRandomNumberBetween(5000, 10000));
            employeeExpense.setOthers(Utils.getRandomNumberBetween(5000, 10000));
            employeeExpenseList.add(employeeExpense);
        }

        List<Expenses> expenseChart = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            Expenses expenses = new Expenses();
            expenses.setMonth(Months.fromInt(i));
            expenses.setExpense(Utils.getRandomNumberBetween(50000, 250000));
            expenseChart.add(expenses);
        }

        List<Expenses> expenseCategory = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            Expenses expenses = new Expenses();
            expenses.setMonth(Months.fromInt(i));
            expenses.setExpense(Utils.getRandomNumberBetween(50000, 250000));
            expenseCategory.add(expenses);
        }
        budget.setEmployeeExpense(employeeExpenseList);
        budget.setExpenseChart(expenseChart);
        budget.setExpenseCategory(expenseCategory);
        return budget;
    }
}
