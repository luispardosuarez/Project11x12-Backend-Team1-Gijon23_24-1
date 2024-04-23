package com.x12.project11x12.facades.payments;

import com.stripe.exception.StripeException;
import com.x12.project11x12.payments.PaymentRequest;
import com.x12.project11x12.payments.PaymentResponse;

public class PaymentFacade implements IPaymentFacade<PaymentResponse> {

    StripePayment stripePayment;

    public PaymentResponse createPaymentIntent(String type, PaymentRequest payment) throws StripeException {

        PaymentResponse response = new PaymentResponse();

        if (type == "stripe") response = stripePayment.createPaymentIntent(payment);

        return response;
    }
}