package com.penny.demo.penny.serviceimpl;

import com.penny.demo.penny.entity.Vendor;
import com.penny.demo.penny.repository.VendorRepository;
import com.penny.demo.penny.service.UserValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendorService {
    @Autowired
    private VendorRepository repository;

    @Autowired
    private UserValidationService userValidationService;
    public List<Vendor> getVendorsDetails(){
        return repository.findAll();
    }

    public Vendor getVendorDetails(){
        return repository.findVendor();
    }
}
