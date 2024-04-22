package com.x12.project11x12.payments;

public class Calculator {
    
    public static Long calculateOrderAmount(PaymentItem[] items) {

        Long total = 0L; 
    
        for (PaymentItem object : items) {
          total += object.getPrice();
        }
        return total;
      }
    
}
