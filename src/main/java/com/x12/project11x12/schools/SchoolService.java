package com.x12.project11x12.schools;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolService {

    private final SchoolRepository schoolRepository;

    @Autowired
    public SchoolService(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    public List<School> getAllSchools() {
        return schoolRepository.findAll();
    }

    public School getSchoolById(Long id) {
        return schoolRepository.findById(id)
                .orElseThrow(() -> new SchoolNotFoundException("School not found with id: " + id));
    }

    public School createSchool(School school) {
        return schoolRepository.save(school);
    }

    public School updateSchool(Long id, School schoolDetails) {
        School school = schoolRepository.findById(id)
                .orElseThrow(() -> new SchoolNotFoundException("School not found with id: " + id));

        school.setSchoolName(schoolDetails.getSchoolName());

        return schoolRepository.save(school);
    }

    public void deleteSchool(Long id) {
        School school = schoolRepository.findById(id)
                .orElseThrow(() -> new SchoolNotFoundException("School not found with id: " + id));

        schoolRepository.delete(school);
    }
}
