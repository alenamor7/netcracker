package com.netcracker.service;

import com.netcracker.model.Customer;

import java.util.List;

public interface ICustomerService {
    void saveCustomer(Customer entity);

    List<Customer> findAllCustomers();

    Customer findCustomerById(int id);

    void deleteCustomerById(int id);

    long rowCount();

    List getCustomersDistrict();

    List getSurnameAndDiscount();
}
