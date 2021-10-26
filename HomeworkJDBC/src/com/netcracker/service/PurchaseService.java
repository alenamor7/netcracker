package com.netcracker.service;


import com.netcracker.dao.purchase.IPurchaseDAO;
import com.netcracker.model.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("purchaseService")
public class PurchaseService implements IPurchaseService{
    @Autowired
    IPurchaseDAO purchaseDAO;

    @Override
    public void savePurchase(Purchase entity) {
        purchaseDAO.savePurchase(entity);
    }

    @Override
    public List<Purchase> findAllPurchases() {
        return purchaseDAO.findAllPurchases();
    }

    @Override
    public Purchase findPurchaseById(int id) {
        return purchaseDAO.findPurchaseById(id);
    }

    @Override
    public void deletePurchaseById(int id) {
        purchaseDAO.deletePurchaseById(id);
    }

    @Override
    public long rowCount() {
        return purchaseDAO.rowCount();
    }

    @Override
    public List getMonthes() {
        return purchaseDAO.getMonthes();
    }

    @Override
    public List getSurnameAndShopname() {
        return purchaseDAO.getSurnameAndShopname();
    }

    @Override
    public List getIdSurnameDate() {
        return purchaseDAO.getIdSurnameDate();
    }

    @Override
    public List getSomePurchaseInfo() {
        return purchaseDAO.getSomePurchaseInfo();
    }
}
