package com.x12.project11x12.inscriptionsParticipants;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InscriptionParticipantRepository extends JpaRepository <InscriptionParticipant, Long> {
    Optional <InscriptionParticipant> findById(Long id);

}
