package com.x12.project11x12.participants;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

@SpringBootTest
public class ParticipantTest {

    private ParticipantService participantService;
    private ParticipantController participantController;

    @BeforeEach
    public void setUp() {
        participantService = mock(ParticipantService.class);
        participantController = new ParticipantController(participantService);
    }

    @Test
    public void testGetAllParticipants() {
        List<Participant> participants = new ArrayList<>();
        participants.add(new Participant(1L, "Pablo", "Sánchez", "09765432B", "Asturias", "33202", "Gijón", "Gijón", "pabloschz@gijon11x12.com", new Date(2019 - 1900, 4, 15), "Aspirina", "", null, 1, null));
        // Los demás participantes van aquí...

        when(participantService.getAllParticipants()).thenReturn(participants);

        ResponseEntity<List<Participant>> response = participantController.getAllParticipants();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(6, response.getBody().size());
    }

    // Otras pruebas relacionadas con la entidad Participant pueden ir aquí
}

