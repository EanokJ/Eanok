package com.penny.demo.penny.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="invoice")
public class Invoice {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int invoiceIid;
    private int userRefId;
    private String issueDate;
    private String dueDate;
    private Vendor vendor;
    private String vendorAddress;
    private String invoiceNumber;
    private String reason;
    private String type;
    private String status;
    private String state;
    private double totalAmount;
    private String currency;
    private String invoiceDate;

}
