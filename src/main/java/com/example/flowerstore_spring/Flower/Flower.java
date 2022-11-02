package com.example.flowerstore_spring.Flower;

import com.example.flowerstore_spring.Item;
import lombok.Getter;

public class Flower extends Item {
    @Getter
    private final int sepalLength;
    @Getter
    private final String color;
    @Getter
    protected final double price;

    public Flower(
            String description,
            double price,
            String color,
            int sepalLength
    ) {
        super(description);
        this.price = price;
        this.sepalLength = sepalLength;
        this.color = color;
    }

    @Override
    public double price() {
        return this.price;
    }
}
