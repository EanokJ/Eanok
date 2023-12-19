package com.penny.demo.penny.model.forcast;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.penny.demo.penny.model.Months;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Scenarios {
    @Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class ScenarioCashFlow{
        private Months month;
        private Double mainScenario;
        private Double receptionOfFunding;
        private Double revenue;
        private Double latePayments;
    }
    private List<ScenarioCashFlow> scenarioCashFlow;
}
