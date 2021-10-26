package com.netcracker.model;

import javax.persistence.*;

@Entity
@Table(name = "shop")
public class Shop {
    @Id
    @Column(name = "shop_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name =" name")
    private String name;
    @Column(name = "district")
    private String district;
    @Column(name = "comission")
    private int comission;

    public Shop() {
    }

    public Shop(String name, String district, int comission) {
        this.name = name;
        this.district = district;
        this.comission = comission;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDistrict() {
        return district;
    }

    public int getComission() {
        return comission;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setComission(int comission) {
        this.comission = comission;
    }
}

