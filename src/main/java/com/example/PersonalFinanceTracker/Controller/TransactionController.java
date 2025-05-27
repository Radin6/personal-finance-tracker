package com.example.PersonalFinanceTracker.Controller;

import com.example.PersonalFinanceTracker.DTO.TransactionRequest;
import com.example.PersonalFinanceTracker.Entity.Transaction;
import com.example.PersonalFinanceTracker.Service.TransactionService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService){
        this.transactionService = transactionService;
    }

    @Operation(summary = "Get all transactions", description = "")
    @GetMapping
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    @Operation(summary = "Create a new transaction", description = "")
    @PostMapping
    public String addTransaction(@RequestBody TransactionRequest newTransaction) {
        transactionService.addTransaction(newTransaction);
        return "Transaction created";
    }
}
