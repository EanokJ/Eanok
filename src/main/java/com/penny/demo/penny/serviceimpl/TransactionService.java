package com.penny.demo.penny.serviceimpl;

import com.penny.demo.penny.entity.Transactions;
import com.penny.demo.penny.repository.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    @Autowired
    TransactionsRepository transactionsRepository;

    public List<Transactions> getAllTransactions(){
        return transactionsRepository.findAll();
    }
}
