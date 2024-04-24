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
import java.time.LocalDate;

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
    public void testCreateParticipant() {
        Participant newParticipant = new Participant(7L, "Nuevo", "Participante", "12345678Z", "Calle Nueva", "33000", "Gijón", "Gijón", "nuevo@gijon11x12.com", LocalDate.of(2023, 1, 1), "", "", null, 1, null);

        when(participantService.createParticipant(any(Participant.class))).thenReturn(newParticipant);

        ResponseEntity<Participant> response = participantController.createParticipant(newParticipant);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(newParticipant, response.getBody());
    }

    @Test
    public void testGetParticipantById() {
        Participant participant = new Participant(3L, "María", "Díaz", "35467339H", "Galicia", "33211", "Gijón", "Gijón", "maria19@gijon11x12.com", LocalDate.of(2020, 6, 19), "", "", null, 2, null);

        when(participantService.getParticipantById(3L)).thenReturn(participant);

        ResponseEntity<Participant> response = participantController.getParticipantById(3L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(participant, response.getBody());
    }

    @Test
    public void testGetAllParticipants() {
        List<Participant> participants = new ArrayList<>();
        participants.add(new Participant(1L, "Pablo", "Sánchez", "09765432B", "Asturias", "33202", "Gijón", "Gijón", "pabloschz@gijon11x12.com", LocalDate.of(2019, 5, 15), "Aspirina", "", null, 1, null));
        participants.add(new Participant(2L, "Ana", "Sánchez", "09855432S", "Asturias", "33202", "Gijón", "Gijón", "anaschz@gijon11x12.com", LocalDate.of(2021, 7, 21), "Cacahuetes", "Medicación en la mochila para usar en caso de intoxicación accidental", null, 1, null));
        participants.add(new Participant(3L, "María", "Díaz", "35467339H", "Galicia", "33211", "Gijón", "Gijón", "maria19@gijon11x12.com", LocalDate.of(2020, 6, 19), "", "", null, 2, null));
        participants.add(new Participant(4L, "Alberto", "Castillo", "10715412C", "Carlos Marx", "33207", "Gijón", "Gijón", "albertito@gijon11x12.com", LocalDate.of(2019, 7, 17), "", "", null, 3, null));
        participants.add(new Participant(5L, "Zaira", "Castillo", "05833432Y", "Carlos Marx", "33207", "Gijón", "Gijón", "zairita@gijon11x12.com", LocalDate.of(2021, 2, 21), "Gluten", "Se olvida de poner las gafas", null, 3, null));
        participants.add(new Participant(6L, "Marcos", "Rodríguez", "15499939F", "Peña Mea", "33211", "Tremañes", "Gijón", "maroz13@gijon11x12.com", LocalDate.of(2020, 3, 13), "", "", null, 4, null));

        when(participantService.getAllParticipants()).thenReturn(participants);

        ResponseEntity<List<Participant>> response = participantController.getAllParticipants();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(participants, response.getBody());
    }

    @Test
    public void testUpdateParticipant() {
        Participant updatedParticipant = new Participant(3L, "María", "Díaz", "35467339H", "Galicia", "33211", "Gijón", "Gijón", "nuevaemail@gijon11x12.com", LocalDate.of(2020, 6, 19), "", "Actualizado", null, 2, null);

        when(participantService.updateParticipant(3L, updatedParticipant)).thenReturn(updatedParticipant);

        ResponseEntity<Participant> response = participantController.updateParticipant(3L, updatedParticipant);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(updatedParticipant, response.getBody());
    }

    @Test
    public void testDeleteParticipant() {
        ResponseEntity<String> response = participantController.deleteParticipant(3L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Participant deleted successfully", response.getBody());
    }
}




