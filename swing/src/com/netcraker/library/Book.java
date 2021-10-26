package com.netcraker.library;

public class Book {
    private String name;
    private Author author;
    private String genre;
    private int year;
    private double price;
    private int qty = 0;


    public Book(String name, Author author, double price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    public Book(String name, Author author, String genre, int year, double price, int qty) {
        this.name = name;
        this.author = author;
        this.genre = genre;
        this.year = year;
        this.price = price;
        this.qty = qty;
    }

    public String getName() {
        return name;
    }

    public Author getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

    public int getQty() {
        return qty;
    }

    public void setPrice(double priice) {
        this.price = price;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name = '" + name + '\'' +
                ", author = " + author +
                ", year = " + year +
                ", price = " + price +
                ", qty = " + qty +
                '}';
    }
}
