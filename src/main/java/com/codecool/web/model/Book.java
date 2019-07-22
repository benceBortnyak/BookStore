package com.codecool.web.model;

public class Book {
    private final int book_id;
    private final String book_title;
    private final String book_author;
    private final int book_page;
    private int book_price;
    private int stock;

    public Book(int book_id, String book_title, String book_author, int book_page, int book_price, int stock) {
        this.book_id = book_id;
        this.book_title = book_title;
        this.book_author = book_author;
        this.book_page = book_page;
        this.book_price = book_price;
        this.stock = stock;
    }

    public int getBook_id() {
        return book_id;
    }

    public String getBook_title() {
        return book_title;
    }

    public String getBook_author() {
        return book_author;
    }

    public int getBook_page() {
        return book_page;
    }

    public int getBook_price() {
        return book_price;
    }

    public void setBook_price(int book_price) {
        this.book_price = book_price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
