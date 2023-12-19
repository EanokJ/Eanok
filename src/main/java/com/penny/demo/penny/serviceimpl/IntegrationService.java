package com.penny.demo.penny.serviceimpl;

import com.penny.demo.penny.entity.Bank;
import com.penny.demo.penny.entity.Integrations;
import com.penny.demo.penny.repository.BankRepository;
import com.penny.demo.penny.repository.IntegrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IntegrationService {
    @Autowired
    private IntegrationRepository integrationRepository;
    @Autowired
    BankRepository bankRepository;
    public List<Integrations> getAllIntegrations(){
        return integrationRepository.findAll();
    }

    public List<Bank> getAllBanks(){
        return bankRepository.findAll();
    }
}
