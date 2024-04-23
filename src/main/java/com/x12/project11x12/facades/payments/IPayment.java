package com.x12.project11x12.facades.payments;

import com.x12.project11x12.payments.PaymentRequest;

public interface IPayment<T> {
    
    T createPaymentIntent(PaymentRequest request) throws Exception;

}
