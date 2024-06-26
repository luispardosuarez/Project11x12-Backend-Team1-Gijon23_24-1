package com.x12.project11x12.users;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.x12.project11x12.roles.Role;

public interface UserRepository extends JpaRepository <User, Long> {
    public Optional<User> findByUsername(String username);

    public Set<Role> findRolesByUsername(String username);
        
}
