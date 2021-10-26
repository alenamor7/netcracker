package com.netcracker.dao.shop;

import com.netcracker.model.Shop;

import java.util.List;

public interface IShopDAO {

    void saveShop(Shop entity);

    List<Shop> findAllShops();

    Shop findShopById(int id);

    void deleteShopById(int id);

    long rowCount();

    List<Shop> getShopsByDistrict();

    List getShopname();
}
