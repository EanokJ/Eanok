package com.penny.demo.penny.model.forcast;

import com.penny.demo.penny.model.Months;
import lombok.Data;

import java.util.List;

@Data
public class CashFlowPosition {
    @Data
    public static class PositionCashFlow{
        private Months month;
        private double mainScenario;
        private double hiringNewStaffs;
        private double investment;
    }
    private List<PositionCashFlow> positionCashFlows;
}
