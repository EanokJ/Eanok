package com.penny.demo.penny.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="vendor")
public class Vendor {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int vendorID;
    private int userRefID;
    private String name;
    private String CINNumber;
    private String VATNumber;
    private String vendorAddress;
    private String email;
    private String mobile;
}
