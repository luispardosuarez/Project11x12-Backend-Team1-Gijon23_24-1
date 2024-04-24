package com.x12.project11x12.scholarship;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ScholarshipTest {

    private ScholarshipService scholarshipService;
    private ScholarshipRepository scholarshipRepository;

    @BeforeEach
    public void setUp() {
        scholarshipRepository = mock(ScholarshipRepository.class);
        scholarshipService = new ScholarshipService(scholarshipRepository);
    }

    @Test
    public void testGetAllScholarships() {
        // Arrange
        List<Scholarship> scholarships = new ArrayList<>();
        scholarships.add(new Scholarship("10000067X", Date.valueOf("2024-12-22"), Date.valueOf("2025-01-09")));
        scholarships.add(new Scholarship("11003445P", Date.valueOf("2024-12-22"), Date.valueOf("2025-01-09")));
        when(scholarshipRepository.findAll()).thenReturn(scholarships);

        // Act
        List<Scholarship> result = scholarshipService.getAll();

        // Assert
        assertEquals(scholarships.size(), result.size());
        assertEquals(scholarships, result);
    }

    @Test
    public void testGetScholarshipById_Success() {
        // Arrange
        Long id = 1L;
        Scholarship scholarship = new Scholarship("10000067X", Date.valueOf("2024-12-22"), Date.valueOf("2025-01-09"));
        when(scholarshipRepository.findById(id)).thenReturn(Optional.of(scholarship));

        // Act & Assert
        assertDoesNotThrow(() -> {
            Scholarship result = scholarshipService.getById(id);
            assertEquals(scholarship, result);
        });
    }

    @Test
    public void testGetScholarshipById_NotFound() {
        // Arrange
        Long id = 1L;
        when(scholarshipRepository.findById(id)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(ScholarshipNotFoundException.class, () -> scholarshipService.getById(id));
    }

    @Test
    public void testSaveScholarship() {
        // Arrange
        Scholarship scholarshipToSave = new Scholarship("10000067X", Date.valueOf("2024-12-22"), Date.valueOf("2025-01-09"));
        when(scholarshipRepository.save(scholarshipToSave)).thenReturn(scholarshipToSave);

        // Act
        Scholarship savedScholarship = scholarshipService.save(scholarshipToSave);

        // Assert
        assertNotNull(savedScholarship);
        assertEquals(scholarshipToSave.getDni(), savedScholarship.getDni());
        assertEquals(scholarshipToSave.getStart_date(), savedScholarship.getStart_date());
        assertEquals(scholarshipToSave.getEnd_date(), savedScholarship.getEnd_date());
    }

    @Test
    public void testUpdateScholarship_Success() throws ScholarshipNotFoundException {
        // Arrange
        Long id = 1L;
        Scholarship scholarshipToUpdate = new Scholarship("10000067X", Date.valueOf("2024-12-22"), Date.valueOf("2025-01-09"));
        Scholarship updatedScholarship = new Scholarship("11003445P", Date.valueOf("2024-12-22"), Date.valueOf("2025-01-09"));
        when(scholarshipRepository.findById(id)).thenReturn(Optional.of(scholarshipToUpdate));
        when(scholarshipRepository.save(scholarshipToUpdate)).thenReturn(updatedScholarship);

        // Act
        Scholarship result = scholarshipService.update(id, updatedScholarship);

        // Assert
        assertEquals(updatedScholarship.getDni(), result.getDni());
        assertEquals(updatedScholarship.getStart_date(), result.getStart_date());
        assertEquals(updatedScholarship.getEnd_date(), result.getEnd_date());
    }

    @Test
    public void testUpdateScholarship_NotFound() {
        // Arrange
        Long id = 1L;
        Scholarship updatedScholarship = new Scholarship("11003445P", Date.valueOf("2024-12-22"), Date.valueOf("2025-01-09"));
        when(scholarshipRepository.findById(id)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(ScholarshipNotFoundException.class, () -> scholarshipService.update(id, updatedScholarship));
    }

    @Test
    public void testDeleteScholarship_Success() throws ScholarshipNotFoundException {
        // Arrange
        Long id = 1L;
        when(scholarshipRepository.existsById(id)).thenReturn(true);

        // Act
        assertDoesNotThrow(() -> scholarshipService.deleteById(id));

        // Assert: no exceptions thrown
    }

    @Test
    public void testDeleteScholarship_NotFound() {
        // Arrange
        Long id = 1L;
        when(scholarshipRepository.existsById(id)).thenReturn(false);

        // Act & Assert
        assertThrows(ScholarshipNotFoundException.class, () -> scholarshipService.deleteById(id));
    }
}
