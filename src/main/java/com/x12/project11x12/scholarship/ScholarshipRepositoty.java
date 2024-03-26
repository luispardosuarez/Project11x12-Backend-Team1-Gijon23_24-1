package com.x12.project11x12.scholarship;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ScholarshipRepositoty extends JpaRepository<Scholarship, Long> {
    public Optional<Scholarship> findByDni(String scholarship);
    
}
