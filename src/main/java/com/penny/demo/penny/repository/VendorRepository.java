package com.penny.demo.penny.repository;

import com.penny.demo.penny.entity.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, Integer> {
    List<Vendor> findAllByUserRefID(int userRefID);

    @Query(value = "SELECT * from vendor limit 1", nativeQuery = true)
    Vendor findVendor();
}
