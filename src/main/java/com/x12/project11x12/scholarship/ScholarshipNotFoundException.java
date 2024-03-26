package com.x12.project11x12.scholarship;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Council not found")
public class ScholarshipNotFoundException extends Exception {

    public ScholarshipNotFoundException(String message){
        super(message);
    }

    public ScholarshipNotFoundException(String message, Throwable cause){
        super(message, cause);
    }
    
}
