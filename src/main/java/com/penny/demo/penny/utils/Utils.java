package com.penny.demo.penny.utils;

import lombok.NoArgsConstructor;

import java.text.DecimalFormat;
import java.util.Random;

@NoArgsConstructor
public class Utils {
    private static final DecimalFormat decfor = new DecimalFormat("0.00");
    private static Random random = new Random();
    public static double getRandomNumberBetween(double from, double to){
        double cash;
        for (; ; ) {
            cash = random.nextDouble(to);
            if (cash > from) {
                return Double.parseDouble(decfor.format(cash));
            }
        }
    }

}
