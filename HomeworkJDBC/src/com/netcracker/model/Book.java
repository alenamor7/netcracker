package com.netcracker.model;


import javax.persistence.*;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @Column(name = "book_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "price", nullable = false)
    private double price;
    @Column(name = "storehouse", nullable = false)
    private String storehouse;
    @Column(name = "qty", nullable = false)
    private int qty;

    public Book() {
    }

    public Book(String title, float price, String storehouse, int qty) {
        this.title = title;
        this.price = price;
        this.storehouse = storehouse;
        this.qty = qty;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public String getStorehouse() {
        return storehouse;
    }

    public int getQty() {
        return qty;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStorehouse(String storehouse) {
        this.storehouse = storehouse;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", storehouse='" + storehouse + '\'' +
                ", qty=" + qty +
                '}';
    }
}
