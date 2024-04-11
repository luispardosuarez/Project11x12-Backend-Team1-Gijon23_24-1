package com.x12.project11x12.inscriptions;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InscriptionsRepository extends JpaRepository<Inscriptions, Long> {
    Optional <Inscriptions> findById(Long id);
    
}
