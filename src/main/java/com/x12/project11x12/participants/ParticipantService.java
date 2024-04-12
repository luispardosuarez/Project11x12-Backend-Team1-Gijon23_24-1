package com.x12.project11x12.participants;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipantService {

    private final ParticipantRepository participantRepository;

    public ParticipantService(ParticipantRepository participantRepository) {
        this.participantRepository = participantRepository;
    }

    public List<Participant> getAllParticipants() {
        return participantRepository.findAll();
    }

    public Participant getParticipantById(Long id) {
        return participantRepository.findById(id).orElse(null);
    }

    public Participant createParticipant(Participant participant) {
        return participantRepository.save(participant);
    }

    public Participant updateParticipant(Long id, Participant participantDetails) {
        Participant participant = participantRepository.findById(id).orElse(null);
        if (participant == null) {
            return null;
        }
        participant.setParticipantName(participantDetails.getParticipantName());
        participant.setParticipantSurname(participantDetails.getParticipantSurname());
        participant.setDni(participantDetails.getDni());
        participant.setStreet(participantDetails.getStreet());
        participant.setPc(participantDetails.getPc());
        participant.setCity(participantDetails.getCity());
        participant.setMunicipality(participantDetails.getMunicipality());
        participant.setMail(participantDetails.getMail());
        participant.setBirthDate(participantDetails.getBirthDate());
        participant.setAllergies(participantDetails.getAllergies());
        participant.setRemarks(participantDetails.getRemarks());
        return participantRepository.save(participant);
    }

    public void deleteParticipant(Long id) {
        participantRepository.deleteById(id);
    }
}
