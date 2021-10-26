package com.netcracker.crud.dao;

import com.netcracker.crud.model.Customer;

import java.util.List;

public interface ICustomerDAO {

    void saveCustomer(Customer customer);

    List<Customer> findAllCustomers();

    Customer findCustomerById(int id);

    int deleteCustomerById(int id);

    void deleteAllCutomers();
}
