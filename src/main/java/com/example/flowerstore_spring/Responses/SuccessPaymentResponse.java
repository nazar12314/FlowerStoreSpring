package com.example.flowerstore_spring.Responses;

import lombok.Getter;

@Getter
public class SuccessPaymentResponse extends Response {

    private final double price;
    public SuccessPaymentResponse(String message, double price) {
        super(message);
        this.price = price;
    }
}
