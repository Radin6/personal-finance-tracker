package com.example.PersonalFinanceTracker.Controller;

import com.example.PersonalFinanceTracker.Entity.Transaction;
import com.example.PersonalFinanceTracker.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tran")
public class TransactionController {

    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService){
        this.transactionService = transactionService;
    }

    @GetMapping
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    @PostMapping
    public String addTransaction(@RequestBody Transaction newTransaction) {
        transactionService.addTransaction(newTransaction);
        return "Transaction created";
    }
}
