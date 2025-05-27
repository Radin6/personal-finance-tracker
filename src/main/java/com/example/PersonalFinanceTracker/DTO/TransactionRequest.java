package com.example.PersonalFinanceTracker.DTO;

import com.example.PersonalFinanceTracker.Entity.TransactionType;
import lombok.Data;

@Data
public class TransactionRequest {
    private Long userId;

    private String description;
    private Long amount;
    private TransactionType type;
}
