package com.penny.demo.penny.model.insights;

import lombok.Data;

@Data
public class Insights {
    private NetCashFlow netCashFlow;
    private MoneyFlows moneyFlow;
    private FlowByCategory inflow;
    private FlowByCategory outflow;
}
