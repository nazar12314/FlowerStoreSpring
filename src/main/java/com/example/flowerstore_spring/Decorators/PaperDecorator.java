package com.example.flowerstore_spring.Decorators;

import com.example.flowerstore_spring.Item;

public class PaperDecorator extends ItemDecorator {

    private final Item item;

    public PaperDecorator(Item item) {
        this.item = item;
    }

    @Override
    String getDescription() {
        return null;
    }

    public double getPrice() {
        return 13 + item.price();
    }
}
