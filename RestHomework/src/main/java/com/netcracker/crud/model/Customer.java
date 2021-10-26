package com.netcracker.crud.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Customer {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "surname")
    private String surname;
    @Column(name = "district")
    private String district;
    @Column(name = "discount")
    private int discount;

    public Customer(String surname, String district, int discount) {
        this.surname = surname;
        this.district = district;
        this.discount = discount;
    }

    public Customer() {
    }

    public int getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public String getDistrict() {
        return district;
    }

    public int getDiscount() {
        return discount;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
}
