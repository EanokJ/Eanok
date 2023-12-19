package com.penny.demo.penny.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="integrations")
public class Integrations {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int integrationId;
    private String accountName;
    private String accountId;
    private String lastUpdate;
    private String status;
    private int userRefId;
}
