package com.penny.demo.penny.repository;

import com.penny.demo.penny.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
     User findByUsername(String username);

     @Query(value = "SELECT u.firstname from user u limit ?1", nativeQuery = true)
     List<String> getNames(int limit);

}
