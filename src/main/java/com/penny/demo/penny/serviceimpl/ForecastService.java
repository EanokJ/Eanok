package com.penny.demo.penny.serviceimpl;

import com.penny.demo.penny.model.Months;
import com.penny.demo.penny.model.forcast.*;
import com.penny.demo.penny.utils.Utils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ForecastService {

    public Forecast getForecastDetails(){
        Forecast forecast = new Forecast();
        forecast.setDynamicFlow(new InsightService().getNetCashFlow());
        forecast.setCashFlowForecast(new InsightService().getMoneyFlow());
        forecast.setCashFlowPosition(getCashFlowPosition());
        forecast.setScenarios(getScenarios("reception"));
        return forecast;
    }

    public Forecast getForecastRevenue(){
        Forecast forecast = new Forecast();
        forecast.setDynamicFlow(new InsightService().getNetCashFlow());
        forecast.setCashFlowForecast(new InsightService().getMoneyFlow());
        forecast.setScenarios(getScenarios("revenue"));
        forecast.setRevenue(getRevenueOverview());
        return forecast;
    }

    public ForeCastProfitLoss getProfileAndLoss(){
        ForeCastProfitLoss foreCastProfitLoss = new ForeCastProfitLoss();
        ForeCastProfitLoss.NetIncome netIncome = new ForeCastProfitLoss.NetIncome();
        netIncome.setInterestIncome(Utils.getRandomNumberBetween(1000, 2000));
        netIncome.setRevenues(Utils.getRandomNumberBetween(1000, 2000));
        netIncome.setDonations(Utils.getRandomNumberBetween(1000, 2000));
        netIncome.setTotal(netIncome.getInterestIncome() + netIncome.getDonations() + netIncome.getRevenues());

        ForeCastProfitLoss.ExpenseByDepartment expenseByDepartment = new ForeCastProfitLoss.ExpenseByDepartment();
        expenseByDepartment.setRent(Utils.getRandomNumberBetween(3000, 5000));
        expenseByDepartment.setTravel(Utils.getRandomNumberBetween(5000, 7000));
        expenseByDepartment.setOthers(Utils.getRandomNumberBetween(6000, 10000));
        expenseByDepartment.setTotal(expenseByDepartment.getOthers() + expenseByDepartment.getTravel() + expenseByDepartment.getRent());

        List<ForeCastProfitLoss.NetIncomeTrend> netIncomeList = new ArrayList<>();
        for(int i=0; i<12; i++){
            ForeCastProfitLoss.NetIncomeTrend netIncomeTrend = new ForeCastProfitLoss.NetIncomeTrend();
            netIncomeTrend.setMonth(Months.fromInt(i));
            netIncomeTrend.setAmount(Utils.getRandomNumberBetween(80000, 250000));
            netIncomeList.add(netIncomeTrend);
        }
        List<ForeCastProfitLoss.ExpenseTrend> expenseTrendList = new ArrayList<>();
        for(int i=0; i<12; i++){
            ForeCastProfitLoss.ExpenseTrend expenseTrend = new ForeCastProfitLoss.ExpenseTrend();
            expenseTrend.setMonth(Months.fromInt(i));
            expenseTrend.setAmount(Utils.getRandomNumberBetween(50000, 200000));
            expenseTrendList.add(expenseTrend);
        }
        foreCastProfitLoss.setNetIncome(netIncome);
        foreCastProfitLoss.setExpenseByDepartment(expenseByDepartment);
        foreCastProfitLoss.setExpenseTrends(expenseTrendList);
        foreCastProfitLoss.setNetIncomeTrends(netIncomeList);
        return foreCastProfitLoss;
    }

    public CashFlowPosition getCashFlowPosition(){
        CashFlowPosition cashFlowPosition = new CashFlowPosition();
        List<CashFlowPosition.PositionCashFlow> cashFlow = new ArrayList<>();
        for(int i=0; i<12; i++){
            CashFlowPosition.PositionCashFlow cashFlowPos = new CashFlowPosition.PositionCashFlow();
            cashFlowPos.setMonth(Months.fromInt(i));
            cashFlowPos.setMainScenario(Utils.getRandomNumberBetween(20000, 40000));
            cashFlowPos.setInvestment(Utils.getRandomNumberBetween(40000, 80000));
            cashFlowPos.setHiringNewStaffs(Utils.getRandomNumberBetween(80000, 100000));
            cashFlow.add(cashFlowPos);
        }
        cashFlowPosition.setPositionCashFlows(cashFlow);
        return cashFlowPosition;
    }

    public Scenarios getScenarios(String type){
        Scenarios scenarios = new Scenarios();
        List<Scenarios.ScenarioCashFlow> cashFlow = new ArrayList<>();
        for(int i=0; i<12; i++){
            Scenarios.ScenarioCashFlow cashFlowSce = new Scenarios.ScenarioCashFlow();
            cashFlowSce.setMonth(Months.fromInt(i));
            cashFlowSce.setMainScenario(Utils.getRandomNumberBetween(20000, 40000));
            cashFlowSce.setLatePayments(Utils.getRandomNumberBetween(80000, 100000));
            if(type.equals("revenue"))
                cashFlowSce.setRevenue(Utils.getRandomNumberBetween(100000, 150000));
            else
                cashFlowSce.setReceptionOfFunding(Utils.getRandomNumberBetween(40000, 80000));
            cashFlow.add(cashFlowSce);
        }
        scenarios.setScenarioCashFlow(cashFlow);
        return scenarios;
    }

    public List<Revenue> getRevenueOverview(){
        List<Revenue> revenues = new ArrayList<>();
        for(int i=0; i<12; i++){
            Revenue revenue = new Revenue();
            revenue.setMonth(Months.fromInt(i));
            revenue.setCustomerGrowth(Utils.getRandomNumberBetween(300, 1500));
            revenue.setChurnAdded(Utils.getRandomNumberBetween(300, 1500));
            revenue.setRevenue(Utils.getRandomNumberBetween(15000, 100000));
            revenues.add(revenue);
        }
        return revenues;
    }
}
