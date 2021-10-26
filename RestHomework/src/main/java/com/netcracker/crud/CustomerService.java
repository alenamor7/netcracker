package com.netcracker.crud;

import com.netcracker.crud.dao.CustomerDAOImpl;
import com.netcracker.crud.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerService {

    @Autowired
    private CustomerDAOImpl customerService;

    @GetMapping(value = "/buyer", produces = "application/json")
    public ResponseEntity<List<Customer>> getAllCustomers(){
        List<Customer> customers = customerService.findAllCustomers();
        if(customers.isEmpty()){
            return new ResponseEntity<List<Customer>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
    }

    @PostMapping(value = "/buyer", consumes = "application/json", produces = "application/json")
    public ResponseEntity<CustomerStatus> addCustomer(Customer customer){
        customerService.saveCustomer(customer);
        return new ResponseEntity<CustomerStatus>(new CustomerStatus("Customer created"), HttpStatus.CREATED);
    }

    @GetMapping(value = "/buyer/{id}", produces = "application/json")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") int id){
        Customer customer = customerService.findCustomerById(id);
        if(customer == null){
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Customer>(customer, HttpStatus.OK);
    }

    @DeleteMapping(value = "/buyer/{id}", produces = "application/json")
    public ResponseEntity<CustomerStatus> deleteCustomerById(@PathVariable("id") int id){
        int result = customerService.deleteCustomerById(id);
        if(result == 1){
            return new ResponseEntity<CustomerStatus>(new CustomerStatus("Customer is not found"), HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<CustomerStatus>(new CustomerStatus("Customer was deleted"), HttpStatus.OK);
    }

    @DeleteMapping(value = "buyer", produces = "application/json")
    public ResponseEntity<CustomerStatus> deleteAllCustomers(){
        customerService.deleteAllCutomers();
        return new ResponseEntity<CustomerStatus>(new CustomerStatus("Table is cleaned"), HttpStatus.OK);
    }


}
