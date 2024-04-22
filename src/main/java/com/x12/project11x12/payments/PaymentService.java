package com.x12.project11x12.payments;

import org.springframework.stereotype.Service;

import com.stripe.exception.StripeException;
import com.x12.project11x12.config.payments.stripe.StripeConfiguration;

@Service
public class PaymentService {

    StripeConfiguration stripeConfig;
    PaymentFacade paymentFacade;

    public PaymentResponse createPaymentIntent(String paymentProvider, PaymentRequest payment) throws StripeException {

        PaymentResponse response = paymentFacade.createPaymentIntent("stripe", payment);

        return response;
    
}
