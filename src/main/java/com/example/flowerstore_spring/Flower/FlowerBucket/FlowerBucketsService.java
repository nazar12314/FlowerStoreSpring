package com.example.flowerstore_spring.Flower.FlowerBucket;

import com.example.flowerstore_spring.Flower.Flower;
import lombok.Getter;
import org.springframework.stereotype.Service;
import com.example.flowerstore_spring.Flower.CactusFlower;
import com.example.flowerstore_spring.Flower.RomashkaFlower;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlowerBucketsService {
    @Getter
    private final List<FlowerBucket> flowerBuckets = new ArrayList<>();

    public void addFlowerBucket(FlowerBucket flowerBucket) {
        flowerBuckets.add(flowerBucket);
    }

    public List<FlowerBucket> initFlowerBuckets() {
        FlowerBucket flowerBucket1 = new FlowerBucket(
                "First flower bucket with beautiful flowers"
        );
        FlowerBucket flowerBucket2 = new FlowerBucket(
                "Second flower bucket with even more beautiful flowers"
        );

        Flower flower1 = new RomashkaFlower(
                "Romashka",
                24,
                "white",
                10
        );
        Flower flower2 = new RomashkaFlower(
                "Romashka",
                20,
                "yellow",
                7
        );

        Flower flower3 = new CactusFlower(
                "Cactus",
                50,
                "green",
                0
        );
        Flower flower4 = new CactusFlower(
                "Cactus",
                70,
                "yellow",
                0
        );

        flowerBucket1.addFlower(flower1);
        flowerBucket1.addFlower(flower3);

        flowerBucket2.addFlower(flower2);
        flowerBucket2.addFlower(flower4);

        return List.of(flowerBucket1, flowerBucket2);
    }
}