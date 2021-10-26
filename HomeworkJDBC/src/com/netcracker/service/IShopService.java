package com.netcracker.service;

import com.netcracker.model.Shop;

import java.util.List;

public interface IShopService {
    void saveShop(Shop entity);

    List<Shop> findAllShops();

    Shop findShopById(int id);

    void deleteShopById(int id);

    long rowCount();

    List<Shop> getShopsByDistrict();

    List getShopname();
}
