package com.penny.demo.penny.entity;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int userID;
    private String userName;
    private String password;
    private String role;
    private String mobileNumber;

}
