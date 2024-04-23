package com.x12.project11x12.config.payments.stripe;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.x12.project11x12.facades.payments.PaymentFacade;
import com.x12.project11x12.facades.payments.StripePayment;

@Configuration
public class StripeConfiguration {

    @Value(value = "${stripe-secret-key}")
    private String secretKey;
   
    public String getSecretKey() {
        return secretKey;
    }

    @Bean
    public StripePayment stripePayment() {
        return new StripePayment(this);
    }

    @Bean
    public PaymentFacade paymentFacade() {
        return new PaymentFacade(stripePayment());
    }
}
