package com.codecool.web.model;

public class Order {
    private final int order_id;
    private final int order_price;
    private final boolean completed;
    private final int order_user_id;

    public Order(int order_id, int order_price, boolean completed,int order_user_id) {
        this.order_id = order_id;
        this.order_price = order_price;
        this.completed = completed;
        this.order_user_id = order_user_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public int getOrder_price() {
        return order_price;
    }

    public boolean isCompleted() {
        return completed;
    }

    public int getOrder_user_id() {
        return order_user_id;
    }
}
