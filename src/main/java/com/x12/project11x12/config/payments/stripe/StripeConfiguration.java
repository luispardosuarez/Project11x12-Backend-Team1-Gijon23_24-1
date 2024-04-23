package com.x12.project11x12.config.payments.stripe;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/* @Configuration
public class StripeConfiguration {
    @Value(value = "${stripe-secret-key}")
    private String secretKey;

    public String getSecretKey() {
        return secretKey;
    }    
} */

/* public class StripeConfiguration {
    private String secretKey;

    public String getSecretKey() {
        return secretKey;
    }

    @Value("${stripe-secret-key}")
    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
        
    }
} */

// PRUEBA
@Configuration
public class StripeConfiguration {

    @Value("${STRIPE_SECRET_KEY}")
    private String secretKey;

    @Bean
    public String stripeSecretKey() {
        return secretKey;
    }

    public String getSecretKey() {
        return secretKey;
    }
}
