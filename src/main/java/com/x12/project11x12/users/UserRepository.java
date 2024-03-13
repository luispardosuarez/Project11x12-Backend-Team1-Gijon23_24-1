package com.x12.project11x12.users;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, Long> {
    public Optional<User> findByUsername(String username);
    
}
