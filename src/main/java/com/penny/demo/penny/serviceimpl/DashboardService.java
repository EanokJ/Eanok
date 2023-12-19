package com.penny.demo.penny.serviceimpl;

import com.penny.demo.penny.model.CashFlow;
import com.penny.demo.penny.model.DashBoard;
import com.penny.demo.penny.model.Expenses;
import com.penny.demo.penny.model.Months;
import com.penny.demo.penny.repository.BankRepository;
import com.penny.demo.penny.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class DashboardService {
    @Autowired
    private NotificationService notificationService;
    @Autowired
    private BankRepository bankRepository;
    private Random random = new Random();

    public DashBoard getDashboardDetails(){
        DashBoard dashBoard = new DashBoard();
        List<CashFlow> cashFlow = new ArrayList<>();
        List<Expenses> expenses = new ArrayList<>();
        double totalPayable = 0, totalReceivable = 0;
        for(int i=0; i<12 ; i++){
            CashFlow cashflo = new CashFlow();
            cashflo.setMonth(Months.fromInt(i));
            double pay = Utils.getRandomNumberBetween(10000,30000);
            totalPayable = totalPayable + pay;
            double receive = Utils.getRandomNumberBetween(8000,30000);
            totalReceivable = totalReceivable + receive;
            cashflo.setPayable(pay);
            cashflo.setReceivable(receive);
            cashFlow.add(cashflo);
        }
        for(int i=0; i<4; i++){
            Expenses expense = new Expenses();
            expense.setMonth(Months.fromInt(i));
            expense.setExpense(Utils.getRandomNumberBetween(10000, 30000));
            expenses.add(expense);
        }
        dashBoard.setTotal(totalPayable+totalReceivable);
        dashBoard.setPayable(totalPayable);
        dashBoard.setReceivable(totalReceivable);
        dashBoard.setExpenses(expenses);
        dashBoard.setCashFlow(cashFlow);
        dashBoard.setNotifications(notificationService.getNotification());
        dashBoard.setBanks(bankRepository.findAll());
        return dashBoard;
    }

    public List<Expenses> getExpenses(int month){
        List<Expenses> expenses = new ArrayList<>();
        for(int i=0; i<month; i++){
            Expenses expense = new Expenses();
            expense.setMonth(Months.fromInt(i));
            expense.setExpense(Utils.getRandomNumberBetween(8000, 30000));
            expenses.add(expense);
        }
        return expenses;
    }
}
