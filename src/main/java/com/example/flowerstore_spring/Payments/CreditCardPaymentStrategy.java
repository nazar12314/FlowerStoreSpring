package com.example.flowerstore_spring.Payments;

import com.example.flowerstore_spring.Responses.Response;
import com.example.flowerstore_spring.Responses.SuccessPaymentResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor @Getter
public class CreditCardPaymentStrategy implements Payment {

    private final String name;
    private final String cardNumber;
    private final int cvv;
    private final String dateOfExpiry;

    @Override
    public Response pay(double price) {
        return new SuccessPaymentResponse(
                "Payment was processed successfully using credit card",
                price
        );
    }
}
