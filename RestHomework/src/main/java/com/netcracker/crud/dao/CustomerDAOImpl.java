package com.netcracker.crud.dao;

import com.netcracker.crud.model.Customer;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class CustomerDAOImpl extends BasicDAO implements ICustomerDAO {
    @Override
    public void saveCustomer(Customer customer) {
        persist(customer);
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
    public int deleteCustomerById(int id) {
        Query query = getSession().createQuery("delete from Customer where id = :id");
        query.setInteger("id",id);
        return query.executeUpdate();
    }

    @Override
    public void deleteAllCutomers() {
        Query query = getSession().createQuery("delete from Customer");
        query.executeUpdate();
    }
}
