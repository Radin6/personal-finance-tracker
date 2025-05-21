package com.example.PersonalFinanceTracker.Repository;

import com.example.PersonalFinanceTracker.Entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
