package com.x12.project11x12.payments;

import org.springframework.stereotype.Service;

import com.x12.project11x12.config.payments.stripe.StripeConfiguration;
import com.x12.project11x12.facades.payments.PaymentFacade;

@Service
public class PaymentService {

    StripeConfiguration stripeConfig;

    private final PaymentFacade paymentFacade;

    public PaymentService(PaymentFacade paymentFacade) {
        this.paymentFacade = paymentFacade;
    }

    public PaymentResponse createPaymentIntent(String paymentProvider, PaymentRequest payment) throws Exception {

        PaymentResponse response = paymentFacade.createPaymentIntent(paymentProvider, payment);
        return response;
    }        
}
