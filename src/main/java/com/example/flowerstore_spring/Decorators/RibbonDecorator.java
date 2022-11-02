package com.example.flowerstore_spring.Decorators;

import com.example.flowerstore_spring.Item;

public class RibbonDecorator extends ItemDecorator {
    private final Item item;

    public RibbonDecorator(Item item) {
        this.item = item;
    }

    @Override
    String getDescription() {
        return item.getDescription();
    }

    public double getPrice() {
        return 40 + item.price();
    }
}
