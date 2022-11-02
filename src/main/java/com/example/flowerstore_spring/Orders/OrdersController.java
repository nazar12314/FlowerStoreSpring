package com.example.flowerstore_spring.Orders;

import com.example.flowerstore_spring.Responses.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/api/orders")
public class OrdersController {
    private final OrdersService ordersService;

    @Autowired
    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
        List<Order> initData = ordersService.initOrderSystem();
        for (Order order : initData) {
            ordersService.addOrder(order);
        }
    }

    // Method for creating orders for demonstrating purposes

    @GetMapping
    public List<Order> getOrders() {
        return ordersService.getOrders();
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable String id) {
        return ordersService.getOrderById(id);
    }

    /*
        Post Request Method for future realisation,
        should add order to the existing orders list
     */
    @PostMapping
    public void addOrder() {}

    @GetMapping("/process/{id}")
    public Response processOrder(@PathVariable String id) {
        return ordersService.processOrder(id);
    }

    @GetMapping("/deliver/{id}")
    public Response deliverOrder(@PathVariable String id) {
        return ordersService.deliverOrder(id);
    }
}