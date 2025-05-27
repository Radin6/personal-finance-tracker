package com.example.PersonalFinanceTracker.DTO;

import lombok.Data;

@Data
public class LoginResponse {
    private String message;
    private String token;
}
