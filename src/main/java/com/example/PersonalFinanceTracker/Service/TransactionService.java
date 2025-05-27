package com.example.PersonalFinanceTracker.Service;

import com.example.PersonalFinanceTracker.DTO.TransactionRequest;
import com.example.PersonalFinanceTracker.Entity.Transaction;
import com.example.PersonalFinanceTracker.Entity.User;
import com.example.PersonalFinanceTracker.Repository.TransactionRepository;
import com.example.PersonalFinanceTracker.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final UserRepository userRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository, UserRepository userRepository) {
        this.transactionRepository = transactionRepository;
        this.userRepository = userRepository;
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Transaction addTransaction(TransactionRequest newTransaction) {

        User user = userRepository.findById(newTransaction.getUserId()).orElseThrow(
                () -> new RuntimeException("User not found")
        );

        Transaction transaction = new Transaction();
        transaction.setUser(user);
        transaction.setDescription(newTransaction.getDescription());
        transaction.setType(newTransaction.getType());
        transaction.setAmount(newTransaction.getAmount());

        return transactionRepository.save(transaction);
    }
}
