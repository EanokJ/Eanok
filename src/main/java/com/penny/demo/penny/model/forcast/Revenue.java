package com.penny.demo.penny.model.forcast;

import com.penny.demo.penny.model.Months;
import lombok.Data;

@Data
public class Revenue {
    private Months month;
    private double customerGrowth;
    private double churnAdded;
    private double revenue;
}
