package com.penny.demo.penny.repository;

import com.penny.demo.penny.entity.Integrations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IntegrationRepository extends JpaRepository<Integrations, Integer> {
    List<Integrations> findAllByUserRefId(int userRefId);
}
