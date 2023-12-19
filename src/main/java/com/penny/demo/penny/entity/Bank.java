package com.penny.demo.penny.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="bank")
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private int bankId;
    private String bankName;
    private String accountNumber;
    private String currency;
    private String status;
    private String lastUpdate;
    private boolean clickPayment;
    private double balance;
    @JsonIgnore
    private int userRefId;
}
