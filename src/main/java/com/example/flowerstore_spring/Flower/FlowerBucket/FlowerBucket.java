package com.example.flowerstore_spring.Flower.FlowerBucket;

import com.example.flowerstore_spring.Flower.Flower;
import com.example.flowerstore_spring.Item;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class FlowerBucket extends Item {

    private final List<Flower> flowerList = new ArrayList<>();

    public FlowerBucket(String description) {
        super(description);
    }

    @Override
    public double price() {
        double price = 0;

        for (Flower flower : flowerList) {
            price += flower.price();
        }

        return price;
    }

    public boolean searchFlower(Flower flower) {
        return flowerList.stream()
                .anyMatch(flowerInstance -> flowerInstance
                        .getClass()
                        .getSimpleName()
                        .equalsIgnoreCase(flower.toString()));
    }

    public void addFlower(Flower flower) {
        flowerList.add(flower);
    }
}
