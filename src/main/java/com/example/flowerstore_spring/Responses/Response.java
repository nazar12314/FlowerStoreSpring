package com.example.flowerstore_spring.Responses;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class Response {

    private final String message;
}
