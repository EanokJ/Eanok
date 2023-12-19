package com.penny.demo.penny.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="transactions")
public class Transactions {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int txnId;
    private String date;
    private String vendor;
    private String referenceNumber;
    private String category;
    private String bank;
    private double totalAmount;
    private String billNumber;
}
