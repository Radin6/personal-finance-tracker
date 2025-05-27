package com.example.PersonalFinanceTracker.DTO;

import com.example.PersonalFinanceTracker.Entity.TransactionType;
import lombok.Data;

@Data
public class TransactionRequest {
    private Long userId; // Delete this when JWT is implemented

    private String description;
    private Long amount;
    private TransactionType type;
}
