package com.x12.project11x12.payments;

public interface PaymentFacade<T> {

    T createPaymentIntent(String type, PaymentRequest request) throws Exception;
    
}