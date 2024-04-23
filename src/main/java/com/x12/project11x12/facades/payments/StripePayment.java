package com.x12.project11x12.facades.payments;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import com.x12.project11x12.config.payments.stripe.StripeConfiguration;
import com.x12.project11x12.payments.Calculator;
import com.x12.project11x12.payments.PaymentRequest;
import com.x12.project11x12.payments.PaymentResponse;

public class StripePayment implements IPayment<PaymentResponse> {

    StripeConfiguration stripeConfig;

    public PaymentResponse createPaymentIntent(PaymentRequest payment) throws StripeException {

        Stripe.apiKey = stripeConfig.getSecretKey();

        Long totalAmount = Calculator.calculateOrderAmount(payment.getItems()); 

        PaymentIntentCreateParams params = PaymentIntentCreateParams.builder()
                .setAmount(totalAmount)
                .setCurrency("eur")
                .setAutomaticPaymentMethods(
                        PaymentIntentCreateParams.AutomaticPaymentMethods
                                .builder()
                                .setEnabled(true)
                                .build())
                .build();

        PaymentIntent paymentIntent = PaymentIntent.create(params);

        PaymentResponse paymentResponse = new PaymentResponse(paymentIntent.getClientSecret());

        return paymentResponse;
    }
}
