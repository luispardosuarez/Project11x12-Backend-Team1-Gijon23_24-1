package com.x12.project11x12.inscriptionsParticipants;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InscriptionParticipantService {

    @Autowired 
    private InscriptionParticipantRepository inscriptionParticipantsRepository;

    public List <InscriptionParticipant> getAllInscriptionParticipant() {
        return inscriptionParticipantsRepository.findAll();
    }

    public Optional <InscriptionParticipant> getInscriptionParticipantById(Long Id) {
        return inscriptionParticipantsRepository.findById(Id);
    }
    
}
