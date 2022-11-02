package com.example.flowerstore_spring;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public abstract class Item {

    private final String description;

    public abstract double price();
}