package com.penny.demo.penny.repository;

import com.penny.demo.penny.entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BankRepository extends JpaRepository<Bank, Integer> {
    public List<Bank> findAllByUserRefId(int userRefId);
}
