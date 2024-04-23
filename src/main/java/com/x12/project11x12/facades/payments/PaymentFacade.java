package com.x12.project11x12.facades.payments;

import com.x12.project11x12.payments.PaymentRequest;
import com.x12.project11x12.payments.PaymentResponse;

public class PaymentFacade implements IPaymentFacade<PaymentResponse> {

    private final StripePayment stripePayment;

    public PaymentFacade(StripePayment stripePayment) {
        this.stripePayment = stripePayment;
    }

    @Override
    public PaymentResponse createPaymentIntent(String type, PaymentRequest payment) throws Exception {
        
        PaymentResponse response = new PaymentResponse();

        if (type.equals("stripe")) {

            response = stripePayment.createPaymentIntent(payment);
        }
      
        return response;
    }
}



