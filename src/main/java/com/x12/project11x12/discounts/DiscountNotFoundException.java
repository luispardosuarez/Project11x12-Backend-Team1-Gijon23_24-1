package com.x12.project11x12.discounts;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Discount not found")
public class DiscountNotFoundException extends RuntimeException {

    public DiscountNotFoundException(String message) {
        super(message);
    }

    public DiscountNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
