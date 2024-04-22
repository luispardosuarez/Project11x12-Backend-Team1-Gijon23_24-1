package com.x12.project11x12.payments;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import com.x12.project11x12.config.payments.stripe.StripeConfiguration;
import com.x12.project11x12.interfaces.IPayment;

public class PaymentResponse implements IPayment<PaymentResponse> {

    StripeConfiguration stripeConfig;

    public PaymentResponse createPaymentIntent(PaymentResponse payment) throws StripeException {

        Stripe.apiKey = stripeConfig.getSecretKey(); // Usar el método para obtener la clave secreta

        Long totalAmount = Calculator.calculateOrderAmount(payment.getItems()); // Obtener el monto total utilizando Calculator

        PaymentIntentCreateParams params = PaymentIntentCreateParams.builder()
            .setAmount(totalAmount) 
            .setCurrency("eur")
            .setAutomaticPaymentMethods(
                PaymentIntentCreateParams.AutomaticPaymentMethods
                    .builder()
                    .setEnabled(true)
                    .build()
            )
            .build();

        PaymentIntent paymentIntent = PaymentIntent.create(params);

        PaymentResponse paymentResponse = new PaymentResponse(paymentIntent.getClientSecret());

        return paymentResponse;
    }
}