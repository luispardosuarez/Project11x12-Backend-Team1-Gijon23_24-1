package com.x12.project11x12.facades.payments;

import com.stripe.Stripe;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import com.x12.project11x12.config.payments.stripe.StripeConfiguration;
import com.x12.project11x12.payments.PaymentRequest;
import com.x12.project11x12.payments.PaymentResponse;

public class StripePayment implements IPayment<PaymentResponse> {

    private final StripeConfiguration stripeConfig;

    public StripePayment(StripeConfiguration stripeConfig) {
        this.stripeConfig = stripeConfig;
    }
  
    @Override
    public PaymentResponse createPaymentIntent(PaymentRequest payment) throws Exception {
        Long totalPrice = payment.getTotalPrice();

        Stripe.apiKey = stripeConfig.getSecretKey();

        PaymentIntentCreateParams params = PaymentIntentCreateParams.builder()
                .setAmount(totalPrice) 
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