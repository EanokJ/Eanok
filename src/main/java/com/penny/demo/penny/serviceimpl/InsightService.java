package com.penny.demo.penny.serviceimpl;

import com.penny.demo.penny.model.Months;
import com.penny.demo.penny.model.insights.FlowByCategory;
import com.penny.demo.penny.model.insights.Insights;
import com.penny.demo.penny.model.insights.MoneyFlows;
import com.penny.demo.penny.model.insights.NetCashFlow;
import com.penny.demo.penny.utils.Utils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class InsightService {
    private Random random = new Random();

    public Insights getAllInsightsDetails() {
        Insights insights = new Insights();
        insights.setInflow(getInFlowByCategory());
        insights.setOutflow(getOutFlowByCategory());
        insights.setNetCashFlow(getNetCashFlow());
        insights.setMoneyFlow(getMoneyFlow());
        return insights;
    }

    public NetCashFlow getNetCashFlow() {
        double tatalCash = 0;
        NetCashFlow netCashFlow = new NetCashFlow();
        List<NetCashFlow.CashFLow> cashFLows = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            NetCashFlow.CashFLow cashFLow = new NetCashFlow.CashFLow();
            double cash = Utils.getRandomNumberBetween(10000, 30000);
            tatalCash = cash + tatalCash;
            cashFLow.setCash(cash);
            cashFLow.setMonth(Months.fromInt(i));
            cashFLows.add(cashFLow);
        }
        netCashFlow.setTotal(tatalCash);
        netCashFlow.setCashFLow(cashFLows);
        return netCashFlow;
    }

    public MoneyFlows getMoneyFlow() {
        MoneyFlows moneyFlows = new MoneyFlows();
        List<MoneyFlows.MoneyFlow> flows = new ArrayList<>();
        double netCashTotal = 0, cashInTotal = 0, expenseTotal = 0;
        for (int i = 0; i < 12; i++) {
            MoneyFlows.MoneyFlow cashFLow = new MoneyFlows.MoneyFlow();
            double netCash = Utils.getRandomNumberBetween(10000, 30000);
            netCashTotal = netCash + netCashTotal;

            double cashIn = Utils.getRandomNumberBetween(7000, 25000);
            cashInTotal = cashIn + cashInTotal;

            double expense = Utils.getRandomNumberBetween(5000, 20000);
            expenseTotal = expense + expenseTotal;

            cashFLow.setMonth(Months.fromInt(i));
            cashFLow.setNetCash(netCash);
            cashFLow.setCashIn(cashIn);
            cashFLow.setExpense(expense);
            flows.add(cashFLow);
        }
        moneyFlows.setMoneyFlow(flows);
        moneyFlows.setExpenseTotal(expenseTotal);
        moneyFlows.setCashInTotal(cashInTotal);
        moneyFlows.setNetCashTotal(netCashTotal);
        return moneyFlows;
    }

    public FlowByCategory getInFlowByCategory() {
        double sum;
        FlowByCategory inFlowByCategory = new FlowByCategory();
        inFlowByCategory.setNoCategory(Utils.getRandomNumberBetween(20000, 30000));
        inFlowByCategory.setInternalBalance(Utils.getRandomNumberBetween(30000, 50000));
        inFlowByCategory.setDeposit(Utils.getRandomNumberBetween(60000, 80000));
        inFlowByCategory.setReceived(Utils.getRandomNumberBetween(70000, 100000));
        inFlowByCategory.setSumAmount(inFlowByCategory.getNoCategory() + inFlowByCategory.getInternalBalance() +
                inFlowByCategory.getDeposit() + inFlowByCategory.getReceived());
        return inFlowByCategory;
    }

    public FlowByCategory getOutFlowByCategory() {
        double sum;
        FlowByCategory outFlowByCategory = new FlowByCategory();
        outFlowByCategory.setNoCategory(Utils.getRandomNumberBetween(20000, 30000));
        outFlowByCategory.setInternalBalance(Utils.getRandomNumberBetween(30000, 50000));
        outFlowByCategory.setOther(Utils.getRandomNumberBetween(60000, 80000));
        outFlowByCategory.setRent(Utils.getRandomNumberBetween(70000, 120000));
        outFlowByCategory.setTaxes(Utils.getRandomNumberBetween(70000, 140000));
        outFlowByCategory.setSumAmount(outFlowByCategory.getNoCategory() + outFlowByCategory.getInternalBalance() +
                outFlowByCategory.getRent() + outFlowByCategory.getOther() + outFlowByCategory.getTaxes());
        return outFlowByCategory;
    }

}
