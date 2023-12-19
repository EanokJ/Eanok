package com.penny.demo.penny.model.forcast;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.penny.demo.penny.model.insights.MoneyFlows;
import com.penny.demo.penny.model.insights.NetCashFlow;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Forecast {
    private NetCashFlow dynamicFlow;
    private MoneyFlows cashFlowForecast;
    private Scenarios scenarios;
    private CashFlowPosition cashFlowPosition;
    private List<Revenue> revenue;
}
