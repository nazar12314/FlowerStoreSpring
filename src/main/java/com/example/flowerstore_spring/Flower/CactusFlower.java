package com.example.flowerstore_spring.Flower;

public class CactusFlower extends Flower {

    public CactusFlower(
            String description,
            double price,
            String color,
            int sepalLength
    ) {
        super(description, price, color, sepalLength);
    }

    @Override
    public double price() {
        return price;
    }
}
