package com.example.staff_management.repository;

import com.example.staff_management.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByName(String name);

    @Query("SELECT acc FROM Account acc WHERE acc.name LIKE %:name%")
    List<Account> findByNameLike(String name);

    @Query("SELECT acc FROM Account acc WHERE acc.name LIKE %:name% AND acc.role = :role")
    List<Account> findByNameLikeAndRole(String name, String role);
}
