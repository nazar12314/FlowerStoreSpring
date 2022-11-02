package com.example.flowerstore_spring.Payments;


import com.example.flowerstore_spring.Responses.Response;

public interface Payment {

    Response pay(double price);
}
