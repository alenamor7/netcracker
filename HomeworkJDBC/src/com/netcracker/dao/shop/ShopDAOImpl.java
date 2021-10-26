package com.netcracker.dao.shop;

import com.netcracker.dao.BasicDAO;
import com.netcracker.model.Book;
import com.netcracker.model.Shop;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository("shopDAO")
@Transactional
public class ShopDAOImpl extends BasicDAO implements IShopDAO {
    @Override
    public void saveShop(Shop entity) {
        persist(entity);
    }

    @Override
    public List<Shop> findAllShops() {
        Criteria criteria = getSession().createCriteria(Shop.class);
        return criteria.list();
    }

    @Override
    public Shop findShopById(int id) {
        Criteria criteria = getSession().createCriteria(Shop.class);
        criteria.add(Restrictions.eq("id",id));
        return (Shop) criteria.uniqueResult();
    }

    @Override
    public void deleteShopById(int id) {
        Query query = getSession().createQuery("delete from Shop where id = :id");
        query.setInteger("id",id);
        query.executeUpdate();
    }

    @Override
    public long rowCount() {
        Criteria criteria = getSession().createCriteria(Shop.class);
        Object res = criteria.setProjection(Projections.rowCount()).uniqueResult();
        return Long.parseLong(res.toString());
    }

    @Override
    public List<Shop> getShopsByDistrict() {   //task 3b
        Criteria criteria = getSession().createCriteria(Shop.class);
        Criterion districtSormovsky = Restrictions.eq("district", "Sormovsky");
        Criterion districtSovetsky = Restrictions.eq("district", "Sovetsky");

        criteria.add(Restrictions.or(districtSormovsky, districtSovetsky));
        return criteria.list();
    }

    @Override
    public List getShopname() {
        SQLQuery query = getSession().createSQLQuery("select shop.name" +
                "from shop, customer, purchase" +
                "where purchase.customer_id = customer.id and purchase.shop_id = shop.id" +
                "and shop.district != \'Avtozavodsky\' and customer.discount between 10 and 15");
        return query.list();
    }
}
