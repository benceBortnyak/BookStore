package com.codecool.web.model;

public class Book {
    private final int bookId;
    private final String bookTitle;
    private final String bookAuthor;
    private final int bookPage;
    private int bookPrice;
    private int stock;

    public Book(int bookId, String bookTitle, String bookAuthor, int bookPage, int bookPrice, int stock) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookPage = bookPage;
        this.bookPrice = bookPrice;
        this.stock = stock;
    }

    public int getBookId() {
        return bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public int getBookPage() {
        return bookPage;
    }

    public int getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(int bookPrice) {
        this.bookPrice = bookPrice;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
