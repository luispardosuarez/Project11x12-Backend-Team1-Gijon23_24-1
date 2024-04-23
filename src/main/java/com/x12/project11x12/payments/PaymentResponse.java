package com.x12.project11x12.payments;

public class PaymentResponse {

    private String clientSecret;

    public PaymentResponse() {
    }

    public PaymentResponse(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }
}

