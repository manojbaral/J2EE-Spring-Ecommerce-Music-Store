package com.manoj.emusicstore.service;

import com.manoj.emusicstore.model.Customer;

import java.util.List;

/**
 * Created by Manoj Baral on 4/12/2017.
 */
public interface CustomerService {

    void addCustomer(Customer customer);

    Customer getCustomerById(int customerId);

    List<Customer> getAllCustomers();

Customer getCustomerByUsername(String username);


}
