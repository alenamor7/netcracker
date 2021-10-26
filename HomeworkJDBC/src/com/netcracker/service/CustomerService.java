package com.netcracker.service;

import com.netcracker.dao.customer.ICustomerDAO;
import com.netcracker.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("customerService")
public class CustomerService implements ICustomerService{

    @Autowired
    ICustomerDAO customerDAO;

    @Override
    public void saveCustomer(Customer entity) {
        customerDAO.saveCustomer(entity);
    }

    @Override
    public List<Customer> findAllCustomers() {
        return customerDAO.findAllCustomers();
    }

    @Override
    public Customer findCustomerById(int id) {
        return customerDAO.findCustomerById(id);
    }

    @Override
    public void deleteCustomerById(int id) {
        customerDAO.deleteCustomerById(id);
    }

    @Override
    public long rowCount() {
        return customerDAO.rowCount();
    }

    @Override
    public List getCustomersDistrict() {
        return customerDAO.getCustomersDistrict();
    }

    @Override
    public List getSurnameAndDiscount() {
        return customerDAO.getSurnameAndDiscount();
    }
}
