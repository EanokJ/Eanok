package com.penny.demo.penny.repository;

import com.penny.demo.penny.entity.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TransactionsRepository extends JpaRepository<Transactions, Integer> {

}
