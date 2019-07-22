package com.codecool.web.model;

public class BookOrders {

    private final int book_orders_id;
    private final int book_id_order;
    private final int order_id_book;

    public BookOrders(int book_orders_id, int book_id_order, int order_id_book) {
        this.book_orders_id = book_orders_id;
        this.book_id_order = book_id_order;
        this.order_id_book = order_id_book;
    }

    public int getBook_orders_id() {
        return book_orders_id;
    }

    public int getBook_id_order() {
        return book_id_order;
    }

    public int getOrder_id_book() {
        return order_id_book;
    }
}

