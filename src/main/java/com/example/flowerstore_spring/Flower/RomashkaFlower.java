package com.example.flowerstore_spring.Flower;

public class RomashkaFlower extends Flower {

    public RomashkaFlower(
            String description,
            double price,
            String color,
            int sepalLength
    ) {
        super(description, price, color, sepalLength);
    }

    @Override
    public double price() {
        return this.price;
    }
}
