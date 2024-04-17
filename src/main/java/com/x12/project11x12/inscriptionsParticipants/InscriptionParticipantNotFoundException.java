package com.x12.project11x12.inscriptionsParticipants;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus (code = HttpStatus.NOT_FOUND, reason = "InscriptionParticipant not found")
public class InscriptionParticipantNotFoundException extends Exception {
    
    public InscriptionParticipantNotFoundException(String message) {
        super(message);
    }

    public InscriptionParticipantNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
