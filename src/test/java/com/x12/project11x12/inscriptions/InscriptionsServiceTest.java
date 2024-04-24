package com.x12.project11x12.inscriptions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InscriptionsServiceTest {

    private InscriptionsRepository inscriptionsRepository;
    private InscriptionsService inscriptionsService;

    @BeforeEach
    public void setUp() {
        inscriptionsRepository = mock(InscriptionsRepository.class);
        inscriptionsService = new InscriptionsService();
        inscriptionsService.setInscriptionsRepository(inscriptionsRepository);
    }

    @Test
    public void testGetAllInscriptions() {
        // Given
        List<Inscriptions> expected = new ArrayList<>();
        expected.add(new Inscriptions(1L, 1, new Date(), 3, null));
        expected.add(new Inscriptions(2L, 2, new Date(), 2, null));
        when(inscriptionsRepository.findAll()).thenReturn(expected);

        // When
        List<Inscriptions> actual = inscriptionsService.getAllInscriptions();

        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void testGetInscriptionById() {
        // Given
        Long id = 1L;
        Inscriptions expected = new Inscriptions(id, 1, new Date(), 3, null);
        when(inscriptionsRepository.findById(id)).thenReturn(Optional.of(expected));

        // When
        Optional<Inscriptions> actual = inscriptionsService.getInscriptionById(id);

        // Then
        assertEquals(Optional.of(expected), actual);
    }
}
