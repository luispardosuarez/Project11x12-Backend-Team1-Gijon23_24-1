package com.x12.project11x12.payments;

import java.util.Arrays;

public class PaymentRequest {

    PaymentItem [] items;

    public PaymentRequest() {
    }

    public PaymentRequest(PaymentItem[] items) {
        this.items = items;
    }

    public PaymentItem[] getItems() {
        return items;
    }

    public void setItems(PaymentItem[] items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "PaymentRequest{" +
                "items=" + Arrays.toString(items) +
                '}';
    }    
}
