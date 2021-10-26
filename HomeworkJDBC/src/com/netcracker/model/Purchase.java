package com.netcracker.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "purchase")
public class Purchase {
    @Id
    @Column(name = "purchase_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "date")
    private Date date;
    @Column(name = "seller")
    @JoinColumn(name = "seller", referencedColumnName = "shop_id")
    private Shop seller;
    @Column(name = "customer")
    @JoinColumn(name = "customer", referencedColumnName = "customer_id")
    private Customer customer;
    @Column(name = "book")
    @JoinColumn(name = "book", referencedColumnName = "book_id")
    private Book book;
    @Column(name = "qty")
    private int qty;
    @Column(name = "price")
    private double price;

    public Purchase() {
    }

    public Purchase(Date date, Shop seller, Customer customer, Book book, int qty, float price) {
        this.date = date;
        this.seller = seller;
        this.customer = customer;
        this.book = book;
        this.qty = qty;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public Shop getSeller() {
        return seller;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Book getBook() {
        return book;
    }

    public int getQty() {
        return qty;
    }

    public double getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setSeller(Shop seller) {
        this.seller = seller;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
