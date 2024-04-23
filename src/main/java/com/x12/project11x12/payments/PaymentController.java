package com.x12.project11x12.payments;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("${api-endpoint}/create-payment-intent")
public class PaymentController {

    private final PaymentService service;

    public PaymentController(PaymentService service) {
        this.service = service;
    }

    @PostMapping("/{paymentProvider}")
    public ResponseEntity<PaymentResponse> create(@PathVariable("paymentProvider") String paymentProvider, @RequestBody PaymentRequest payment) {

        try {
            PaymentResponse response = service.createPaymentIntent(paymentProvider, payment);
            
            return ResponseEntity.status(201).body(response);
            
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new PaymentResponse("Error al procesar el pago"));
        }
    }
}
