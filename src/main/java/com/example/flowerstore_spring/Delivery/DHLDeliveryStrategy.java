package com.example.flowerstore_spring.Delivery;

import com.example.flowerstore_spring.Item;
import com.example.flowerstore_spring.Responses.Response;
import com.example.flowerstore_spring.Responses.SuccessDeliveryResponse;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class DHLDeliveryStrategy implements Delivery {

    private final String name;
    private final String address;

    @Override
    public Response deliver(List<Item> items) {
        return new SuccessDeliveryResponse(
                "Order is delivering!",
                items,
                name,
                address
        );
    }
}
