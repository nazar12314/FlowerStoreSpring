package com.example.flowerstore_spring.Payments;

import com.example.flowerstore_spring.Responses.Response;
import com.example.flowerstore_spring.Responses.SuccessPaymentResponse;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor @ToString
public class PayPalPaymentStrategy implements Payment {

    private final String email;
    private final String password;

    @Override
    public Response pay(double price) {
        return new SuccessPaymentResponse(
                "Payment was processed successfully using PayPal",
                price
        );
    }
}
