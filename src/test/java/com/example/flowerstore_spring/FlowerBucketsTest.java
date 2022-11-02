package com.example.flowerstore_spring;

import com.example.flowerstore_spring.Flower.CactusFlower;
import com.example.flowerstore_spring.Flower.Flower;
import com.example.flowerstore_spring.Flower.FlowerBucket.FlowerBucket;
import com.example.flowerstore_spring.Flower.FlowerBucket.FlowerBucketsService;
import com.example.flowerstore_spring.Flower.RomashkaFlower;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FlowerBucketsTest {

    private FlowerBucketsService flowerBucketsService;

    @BeforeEach
    public void init() {
        flowerBucketsService = new FlowerBucketsService();
    }

    @Test
    public void testPrice() {
        FlowerBucket flowerBucket1 = new FlowerBucket("Romashka FlowerBucket");

        Flower flower1 = new CactusFlower(
                "Green cactus",
                40,
                "green",
                0
        );

        Flower flower2 = new CactusFlower(
                "Green cactus",
                50,
                "green",
                0
        );

        flowerBucket1.addFlower(flower1);
        flowerBucket1.addFlower(flower2);

        flowerBucketsService.addFlowerBucket(flowerBucket1);

        Assertions.assertEquals(
                flowerBucket1.price(), flower1.price() + flower2.price()
        );
    }

    @Test
    public void testFlowerBucketService() {
        FlowerBucket flowerBucket = new FlowerBucket("Cactus FlowerBucket");

        Flower flower1 = new RomashkaFlower(
                "Yellow romashka",
                12,
                "yellow",
                10
        );

        Flower flower2 = new RomashkaFlower(
                "White romashka",
                15,
                "white",
                7
        );

        flowerBucket.addFlower(flower1);
        flowerBucket.addFlower(flower2);

        flowerBucketsService.addFlowerBucket(flowerBucket);

        Assertions.assertTrue(
                flowerBucketsService.getFlowerBuckets().contains(flowerBucket)
        );
    }
}