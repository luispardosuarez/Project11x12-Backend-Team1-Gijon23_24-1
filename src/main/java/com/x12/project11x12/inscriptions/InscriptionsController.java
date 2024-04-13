package com.x12.project11x12.inscriptions;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping(path = "${api-endpoint}/inscriptions")
public class InscriptionsController {

    @Autowired
    private InscriptionsService inscriptionsServices;

    public InscriptionsController(InscriptionsService inscriptionsServices) {
        this.inscriptionsServices = inscriptionsServices;
    }

    @GetMapping
    public List<Inscriptions> getAllInscriptions() {       
        return inscriptionsServices.getAllInscriptions();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Inscriptions> getInscriptionById(@PathVariable Long id) {
        Optional<Inscriptions> inscriptionOptional = inscriptionsServices.getInscriptionById(id);
        if (inscriptionOptional.isPresent()) {
            Inscriptions inscription = inscriptionOptional.get();
            return new ResponseEntity<>(inscription, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}