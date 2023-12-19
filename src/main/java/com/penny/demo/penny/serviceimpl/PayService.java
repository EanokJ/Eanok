package com.penny.demo.penny.serviceimpl;

import com.penny.demo.penny.entity.Invoice;
import com.penny.demo.penny.repository.PayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PayService {

    @Autowired
    private PayRepository repository;

    public List<Invoice> getInvoiceByState(String state){
        return repository.findAllByState(state);
    }

}
