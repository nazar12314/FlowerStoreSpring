package com.example.flowerstore_spring.Orders;

import com.example.flowerstore_spring.Delivery.DHLDeliveryStrategy;
import com.example.flowerstore_spring.Delivery.PostDeliveryStrategy;
import com.example.flowerstore_spring.Flower.Flower;
import com.example.flowerstore_spring.Payments.CreditCardPaymentStrategy;
import com.example.flowerstore_spring.Payments.PayPalPaymentStrategy;
import com.example.flowerstore_spring.Responses.FailedDeliveryResponse;
import com.example.flowerstore_spring.Responses.FailedPaymentResponse;
import com.example.flowerstore_spring.Responses.Response;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.example.flowerstore_spring.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class OrdersService {

    private final List<Order> orderList = new ArrayList<>();

    public void addOrder(Order order) {
        orderList.add(order);
    }

    public List<Order> getOrders() {
        return orderList;
    }

    public Order getOrderById(String id) {
        if (orderList
                .stream()
                .noneMatch(order -> Objects.equals(order.getId(), id))) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Order not found"
            );
        }

        return orderList
                .stream()
                .filter(order -> Objects.equals(order.getId(), id))
                .collect(Collectors.toList())
                .get(0);
    }

    public Response processOrder(String id) {
        Order order;
        try {
            order = getOrderById(id);
        } catch (ResponseStatusException exception) {
            return new FailedPaymentResponse("Order not found");
        }

        return order.processOrder();
    }

    public List<Order> initOrderSystem() {
        Item item1 = new Flower(
                "White tulip",
                20,
                "white",
                4
        );
        Item item2 = new Flower(
                "red rose",
                40,
                "red",
                8
        );

        Order order1 = new Order();
        order1.addItem(item1);
        order1.addItem(item2);

        order1.setPaymentStrategy(new CreditCardPaymentStrategy(
                "Arman",
                "4313222109883722",
                447,
                "16-09-2025"
        ));

        Item item3 = new Flower(
                "Yellow romashka",
                33,
                "yellow",
                6
        );
        Item item4 = new Flower(
                "black rose",
                100,
                "black",
                10
        );

        Order order2 = new Order();
        order2.addItem(item3);
        order2.addItem(item4);

        order2.setPaymentStrategy(
                new PayPalPaymentStrategy("example@gmail.com", "qwerty")
        );
        order1.setDeliveryStrategy(
                new DHLDeliveryStrategy("Nazar", "Lviv, Chvylovogo 29")
        );
        order2.setDeliveryStrategy(
                new PostDeliveryStrategy("Roman", "79059")
        );

        return List.of(order1, order2);
    }

    public Response deliverOrder(String id) {
        Order order;

        try {
            order = getOrderById(id);
        } catch (ResponseStatusException exception) {
            return new FailedDeliveryResponse("Order not found");
        }

        if (!order.isProcessed()) {
            return new FailedDeliveryResponse(
                    "Order is not processed,"
                            + " please process your order and pay for it!"
            );
        }

        return order.deliverOrder();
    }
}