package com.example.flowerstore_spring.Responses;

import lombok.Getter;
import com.example.flowerstore_spring.Item;

import java.util.List;

@Getter
public class SuccessDeliveryResponse extends Response {

    private final List<Item> items;
    private final String name;
    private final String address;

    public SuccessDeliveryResponse(
            String message,
            List<Item> items,
            String name,
            String address
            ) {
        super(message);
        this.items = items;
        this.address = address;
        this.name = name;
    }
}
