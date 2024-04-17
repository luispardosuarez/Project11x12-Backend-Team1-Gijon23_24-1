package com.x12.project11x12.scholarship;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.x12.project11x12.interfaces.IGenericLimtedService;

@RestController
@RequestMapping(path = "${api-endpoint}/scholarship")
public class ScholarshipController {

    IGenericLimtedService<Scholarship> service;

    public ScholarshipController(IGenericLimtedService<Scholarship> service) {
        this.service = service;
    }

    @GetMapping(path = "")
    public List<Scholarship> index() {
        List<Scholarship> scholarships = service.getAll();
        return scholarships;
    }

    @PostMapping(path = "")
    public ResponseEntity<Scholarship> create(@RequestBody Scholarship scholarship) {
        if (scholarship == null) {
            return ResponseEntity.badRequest().build();
        }

        Scholarship newScholarship = service.save(scholarship);
        return ResponseEntity.status(201).body(newScholarship);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Scholarship> update(@PathVariable Long id, @RequestBody Scholarship updatedScholarship) {
        try {
            Scholarship scholarship = service.update(id, updatedScholarship);
            return ResponseEntity.ok(scholarship);
        } catch (ScholarshipNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        try {
            service.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Becado eliminado correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ups.. ha ocurrido un error");
        }
    }

}