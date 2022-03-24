package ru.netology.domain;

public class Book extends Product {
    private String author;

    public Book(int id, String title, int price, String author) {
        super(id, title, price);
        this.author = author;
    }
}

