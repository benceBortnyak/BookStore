package com.codecool.web.model;

public class Order {
    private final int orderId;
    private final boolean completed;
    private final int orderUserId;

    public Order(int orderId, int orderPrice, boolean completed,int orderUserId) {
        this.orderId = orderId;
        this.completed = completed;
        this.orderUserId = orderUserId;
    }

    public int getOrderId() {
        return orderId;
    }

    public boolean isCompleted() {
        return completed;
    }

    public int getOrderUserId() {
        return orderUserId;
    }
}
