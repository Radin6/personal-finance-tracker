package com.example.PersonalFinanceTracker.Repository;

import com.example.PersonalFinanceTracker.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

// Repository: Provides CRUD operations for interact with the DB

public interface UserRepository extends JpaRepository<User, Long> {
    // Finds a user by email
    User findByEmail(String email);

}
