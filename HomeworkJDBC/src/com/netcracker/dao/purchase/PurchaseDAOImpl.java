package com.netcracker.dao.purchase;

import com.netcracker.dao.BasicDAO;
import com.netcracker.model.Customer;
import com.netcracker.model.Purchase;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository("purchaseDAO")
@Transactional
public class PurchaseDAOImpl extends BasicDAO implements IPurchaseDAO {
    @Override
    public void savePurchase(Purchase entity) {
        persist(entity);
    }

    @Override
    public List<Purchase> findAllPurchases() {
        Criteria criteria = getSession().createCriteria(Purchase.class);
        return criteria.list();
    }

    @Override
    public Purchase findPurchaseById(int id) {
        Criteria criteria = getSession().createCriteria(Purchase.class);
        criteria.add(Restrictions.eq("id",id));
        return (Purchase) criteria.uniqueResult();
    }

    @Override
    public void deletePurchaseById(int id) {
        Query query = getSession().createQuery("delete from Purchase where id = :id");
        query.setInteger("id",id);
        query.executeUpdate();
    }

    @Override
    public long rowCount() {
        Criteria criteria = getSession().createCriteria(Purchase.class);
        Object res = criteria.setProjection(Projections.rowCount()).uniqueResult();
        return Long.parseLong(res.toString());
    }

    @Override
    public List getMonthes() {  //task 2c
        SQLQuery query = getSession().createSQLQuery("select distinct month(date) " +
                "from Purchase");
        return query.list();
    }

    @Override
    public List getSurnameAndShopname() {   //task 4a
        SQLQuery query = getSession().createSQLQuery("select customer.surname, shop.name" +
                "from customer, shop" +
                "where purchase.customer_id = customer.id and purchase.shop_id = shop.id");
        return query.list();
    }

    @Override
    public List getIdSurnameDate() {  //task 5.a
        SQLQuery query = getSession().createSQLQuery("select purchase.id, customer.surname, purchase.date" +
                "from purchase, customer" +
                "where purchase.customer_id = customer.id" +
                "and purchase.price >= 6000");
        return query.list();
    }

    @Override
    public List getSomePurchaseInfo() {
        SQLQuery query = getSession().createSQLQuery("select purchase.date, customer.surname, customer,discount, book.title, purchase.qty" +
                "from purchase, customer, book" +
                "where purchase.book_id = book.id and purchase.customer_id = customer.id");
        return query.list();
    }
}
