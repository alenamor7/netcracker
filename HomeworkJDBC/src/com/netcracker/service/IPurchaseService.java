package com.netcracker.service;

import com.netcracker.model.Purchase;

import java.util.List;

public interface IPurchaseService {
    void savePurchase(Purchase entity);

    List<Purchase> findAllPurchases();

    Purchase findPurchaseById(int id);

    void deletePurchaseById(int id);

    long rowCount();

    List getMonthes();

    List getSurnameAndShopname();

    List getIdSurnameDate();

    List getSomePurchaseInfo(); //date, surname, discount, title, qty
}
