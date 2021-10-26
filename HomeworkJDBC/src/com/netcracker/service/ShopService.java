package com.netcracker.service;

import com.netcracker.dao.shop.IShopDAO;
import com.netcracker.model.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("shopService")
public class ShopService implements IShopService {

    @Autowired
    IShopDAO shopDAO;

    @Override
    public void saveShop(Shop entity) {
        shopDAO.saveShop(entity);
    }

    @Override
    public List<Shop> findAllShops() {
        return shopDAO.findAllShops();
    }

    @Override
    public Shop findShopById(int id) {
        return shopDAO.findShopById(id);
    }

    @Override
    public void deleteShopById(int id) {
        shopDAO.deleteShopById(id);
    }

    @Override
    public long rowCount() {
        return shopDAO.rowCount();
    }

    @Override
    public List<Shop> getShopsByDistrict() {
        return shopDAO.getShopsByDistrict();
    }

    @Override
    public List getShopname() {
        return shopDAO.getShopname();
    }
}
