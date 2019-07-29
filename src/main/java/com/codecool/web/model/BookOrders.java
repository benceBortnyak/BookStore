package com.codecool.web.model;

public class BookOrders {

    private final int bookOrdersId;
    private final int bookIdOrder;
    private final int orderIdBook;

    public BookOrders(int bookOrdersId, int bookIdOrder, int orderIdBook) {
        this.bookOrdersId = bookOrdersId;
        this.bookIdOrder = bookIdOrder;
        this.orderIdBook = orderIdBook;
    }

    public int getBookOrdersId() {
        return bookOrdersId;
    }

    public int getBookIdOrder() {
        return bookIdOrder;
    }

    public int getOrderIdBook() {
        return orderIdBook;
    }
}

