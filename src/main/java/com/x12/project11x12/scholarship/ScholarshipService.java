package com.x12.project11x12.scholarship;

import java.util.List;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.x12.project11x12.interfaces.IGenericLimtedService;


@Service
public class ScholarshipService implements IGenericLimtedService<Scholarship>{
    
    ScholarshipRepositoty repository;

    public ScholarshipService(ScholarshipRepositoty repository) {
        this.repository = repository;
    }

    public List<Scholarship> getAll() {
        List<Scholarship> scholarships = repository.findAll();
        return scholarships;
    }

    public Scholarship getById(Long id) throws Exception {
        Scholarship scholarship = repository.findById(id).orElseThrow(()-> new ScholarshipNotFoundException("Scholarship not found"));
        return scholarship;
    }

    public Scholarship save(@NonNull Scholarship scholarship){
        Scholarship newScholarship = scholarship;

        repository.save(newScholarship);
        return newScholarship;
    }

    public Scholarship update(Long id, @NonNull Scholarship updatedScholarship) throws ScholarshipNotFoundException {
        Scholarship scholarship = repository.findById(id)
                .orElseThrow(() -> new ScholarshipNotFoundException("Scholarship not found"));
        
        scholarship.setDni(updatedScholarship.getDni());
        return repository.save(scholarship);
    }

    public void deleteById(Long id) throws Exception {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new ScholarshipNotFoundException("Scholarship not found");
        }
    }


}




