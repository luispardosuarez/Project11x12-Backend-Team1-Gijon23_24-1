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

public class InscriptionsTest {

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
       
        List<Inscriptions> expected = new ArrayList<>();
        expected.add(new Inscriptions(1L, 1, new Date(), 3, null));
        expected.add(new Inscriptions(2L, 2, new Date(), 2, null));
        when(inscriptionsRepository.findAll()).thenReturn(expected);

        List<Inscriptions> actual = inscriptionsService.getAllInscriptions();

        assertEquals(expected, actual);
    }

    @Test
    public void testGetInscriptionById() {
       
        Long id = 1L;
        Inscriptions expected = new Inscriptions(id, 1, new Date(), 3, null);
        when(inscriptionsRepository.findById(id)).thenReturn(Optional.of(expected));

        Optional<Inscriptions> actual = inscriptionsService.getInscriptionById(id);

        assertEquals(Optional.of(expected), actual);
    }
}
