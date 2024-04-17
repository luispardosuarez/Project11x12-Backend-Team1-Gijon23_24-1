package com.x12.project11x12.inscriptionsParticipants;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "${api-endpoint}/inscriptionparticipant")
public class InscriptionParticipantController {

    @Autowired
    private InscriptionParticipantService inscriptionParticipantService;

    public InscriptionParticipantController(InscriptionParticipantService inscriptionParticipantService) {
        this.inscriptionParticipantService = inscriptionParticipantService;
    }

    @GetMapping
    public List<InscriptionParticipant> getAllInscriptionParticipant() {       
        return inscriptionParticipantService.getAllInscriptionParticipant();
    }

    @GetMapping("/{id}")
    public ResponseEntity<InscriptionParticipant> getInscriptionById(@PathVariable Long id) {
        Optional<InscriptionParticipant> inscriptionOptional = inscriptionParticipantService.getInscriptionParticipantById(id);

        
        if (inscriptionOptional.isPresent()) {
            InscriptionParticipant inscriptionParticipant = inscriptionOptional.get();
            return new ResponseEntity<>(inscriptionParticipant, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }    

}


