package com.example.PersonalFinanceTracker.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

// Represent data model for a User class
@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String email;

    @JsonIgnore // It is being ignored when .toString is used
    private String password;
}
