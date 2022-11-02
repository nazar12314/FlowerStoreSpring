package com.example.flowerstore_spring;

import com.example.flowerstore_spring.Delivery.DHLDeliveryStrategy;
import com.example.flowerstore_spring.Delivery.PostDeliveryStrategy;
import com.example.flowerstore_spring.Flower.Flower;
import com.example.flowerstore_spring.Orders.Order;
import com.example.flowerstore_spring.Orders.OrdersService;
import com.example.flowerstore_spring.Payments.CreditCardPaymentStrategy;
import com.example.flowerstore_spring.Payments.PayPalPaymentStrategy;
import com.example.flowerstore_spring.Responses.SuccessDeliveryResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrdersTest {

    private OrdersService ordersService;

    @BeforeEach
    public void init() {
        this.ordersService = new OrdersService();
    }

    @Test
    public void testAddAndGetOrder() {
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

        order1.setDeliveryStrategy(
                new DHLDeliveryStrategy(
                        "Arman",
                        "Lviv, Bandera street"
                )
        );

        ordersService.addOrder(order1);
        // Testing getOrders
        Assertions.assertTrue(
                ordersService.getOrders().contains(order1)
        );
        // Testing getOrderById
        Assertions.assertEquals(
                ordersService.getOrderById(order1.getId()),
                order1
        );
    }

    @Test
    public void testProcessOrder() {
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

        Order order = new Order();
        order.addItem(item3);
        order.addItem(item4);

        order.setPaymentStrategy(
                new PayPalPaymentStrategy(
                        "example@gmail.com",
                        "qwerty"
                )
        );

        order.setDeliveryStrategy(
                new PostDeliveryStrategy("Roman", "79059")
        );

        ordersService.addOrder(order);

        // If order is not processed, it can't be delivered
        Assertions.assertEquals(
                ordersService.deliverOrder(order.getId()).getMessage(),
                "Order is not processed,"
                        + " please process your order and pay for it!"
        );

        // Testing process order
        ordersService.processOrder(order.getId());
        Assertions.assertTrue(order.isProcessed());

        // After order is processed, it's delivery begins
        Assertions.assertEquals(
                ordersService.deliverOrder(order.getId()).getClass(),
                SuccessDeliveryResponse.class
        );
    }
}