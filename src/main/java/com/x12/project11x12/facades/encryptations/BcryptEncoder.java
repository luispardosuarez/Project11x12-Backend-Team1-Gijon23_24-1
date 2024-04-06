package com.x12.project11x12.facades.encryptations;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BcryptEncoder {

    BCryptPasswordEncoder encoder;

    public BcryptEncoder(BCryptPasswordEncoder encoder) {
        this.encoder = encoder;
    }

    public String encode(String data) {
        String dataEncoded = encoder.encode(data);
        return dataEncoded;
    }
    
}
