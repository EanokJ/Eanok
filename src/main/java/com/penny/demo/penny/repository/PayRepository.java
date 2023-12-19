package com.penny.demo.penny.repository;

import com.penny.demo.penny.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PayRepository extends JpaRepository<Invoice, Integer> {
    List<Invoice> findAllByState(String state);
}
