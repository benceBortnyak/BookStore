package com.codecool.web.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Book {
    private int bookId;
    private String bookTitle;
    private String bookAuthor;
    private int bookPage;
    private int stock;

    @JsonCreator
    public Book(@JsonProperty("bookId") int bookId,
                @JsonProperty("bookTitle") String bookTitle,
                @JsonProperty("bookAuthor") String bookAuthor,
                @JsonProperty("bookPage")int bookPage,
                @JsonProperty("stock") int stock) {

        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookPage = bookPage;
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

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public void setBookPage(int bookPage) {
        this.bookPage = bookPage;
    }
}
