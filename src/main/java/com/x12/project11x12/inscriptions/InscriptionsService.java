package com.x12.project11x12.inscriptions;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InscriptionsService {

    @Autowired
    private InscriptionsRepository inscriptionsRepository;

    public List <Inscriptions> getAllInscriptions() {
        return inscriptionsRepository.findAll();
    }

    public Optional<Inscriptions> getInscriptionById(Long id) {
        return inscriptionsRepository.findById(id);
    }
}
