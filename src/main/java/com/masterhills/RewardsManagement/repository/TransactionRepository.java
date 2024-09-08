package com.masterhills.RewardsManagement.repository;

import com.masterhills.RewardsManagement.model.Customer;
import com.masterhills.RewardsManagement.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TransactionRepository extends JpaRepository<Transaction,Long> {

    Optional<Transaction> findByUuid(String uuid);
}
