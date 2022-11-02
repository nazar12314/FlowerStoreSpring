package com.example.flowerstore_spring.Delivery;

import com.example.flowerstore_spring.Item;
import com.example.flowerstore_spring.Responses.Response;

import java.util.List;

public interface Delivery {
    Response deliver(List<Item> items);
}
