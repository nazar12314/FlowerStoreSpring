package com.example.flowerstore_spring.Decorators;

import com.example.flowerstore_spring.Item;

public class BasketDecorator extends ItemDecorator {

    private final Item item;

    public BasketDecorator(Item item) {
        this.item = item;
    }

    @Override
    String getDescription() {
        return item.getDescription();
    }

    public double getPrice() {
        return 4 + item.price();
    }
}
