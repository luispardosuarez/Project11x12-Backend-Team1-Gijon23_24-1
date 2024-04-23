package com.x12.project11x12.payments;

public class PaymentRequest {

    Long totalPrice; 

    public PaymentRequest() {
    }

    public PaymentRequest(Long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }    

    @Override
    public String toString() {
        return "PaymentRequest{" +
                "totalPrice=" + totalPrice +
                '}';
    }

}