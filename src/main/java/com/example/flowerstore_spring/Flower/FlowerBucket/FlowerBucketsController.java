package com.example.flowerstore_spring.Flower.FlowerBucket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController @RequestMapping("/api/flower-buckets")
public class FlowerBucketsController {

    private final FlowerBucketsService flowerBucketService;

    @Autowired
    public FlowerBucketsController(FlowerBucketsService flowerBucketService) {
        this.flowerBucketService = flowerBucketService;
        List<FlowerBucket> initData = flowerBucketService.initFlowerBuckets();

        for (FlowerBucket flowerBucket : initData) {
            flowerBucketService.addFlowerBucket(flowerBucket);
        }
    }

    @PostMapping
    public void addFlowerBucket(@RequestBody FlowerBucket flowerBucket) {
        flowerBucketService.addFlowerBucket(flowerBucket);
    }

    @GetMapping
    public List<FlowerBucket> getFlowerBuckets() {
        return flowerBucketService.getFlowerBuckets();
    }
}