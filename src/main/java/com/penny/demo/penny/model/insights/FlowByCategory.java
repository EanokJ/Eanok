package com.penny.demo.penny.model.insights;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FlowByCategory {
    private Double noCategory;
    private Double internalBalance;
    private Double deposit;
    private Double received;
    private Double rent;
    private Double taxes;
    private Double other;
    private double sumAmount;
}
