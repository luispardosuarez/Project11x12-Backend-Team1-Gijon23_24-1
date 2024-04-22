package com.x12.project11x12.config.payments.stripe;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StripeConfiguration {
    private String secretKey;

    public String getSecretKey() {
        return secretKey;
    }

    @Value("${stripe-secret-key}")
    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }
}
