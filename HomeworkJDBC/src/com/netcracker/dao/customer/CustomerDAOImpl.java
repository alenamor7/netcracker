package com.netcracker.dao.customer;

import com.netcracker.dao.BasicDAO;
import com.netcracker.model.Customer;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository("customerDAO")
@Transactional
public class CustomerDAOImpl extends BasicDAO implements ICustomerDAO {
    @Override
    public void saveCustomer(Customer entity) {
        persist(entity);
    }

    @Override
    public List<Customer> findAllCustomers() {
        Criteria criteria = getSession().createCriteria(Customer.class);
        return criteria.list();
    }

    @Override
    public Customer findCustomerById(int id) {
        Criteria criteria = getSession().createCriteria(Customer.class);
        criteria.add(Restrictions.eq("id",id));
        return (Customer) criteria.uniqueResult();
    }

    @Override
    public void deleteCustomerById(int id) {
        Query query = getSession().createQuery("delete from Customer where id = :id");
        query.setInteger("id",id);
        query.executeUpdate();
    }

    @Override
    public long rowCount() {
        Criteria criteria = getSession().createCriteria(Customer.class);
        Object res = criteria.setProjection(Projections.rowCount()).uniqueResult();
        return Long.parseLong(res.toString());
    }

    @Override
    public List getCustomersDistrict() { //task 2b
        SQLQuery query = getSession().createSQLQuery("select distinct district " +
                "from Customer");
        return query.list();
    }

    @Override
    public List getSurnameAndDiscount() { //task 3a
        SQLQuery query = getSession().createSQLQuery("select surname, discount" +
                "from Custimer" +
                "where district = Nizhegorodsky");
        return query.list();
    }
}
