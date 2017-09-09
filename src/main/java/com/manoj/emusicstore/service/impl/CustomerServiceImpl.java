package com.manoj.emusicstore.service.impl;

import com.manoj.emusicstore.dao.CustomerDao;
import com.manoj.emusicstore.model.Customer;
import com.manoj.emusicstore.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Manoj Baral on 4/12/2017.
 */

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Override
    public void addCustomer(Customer customer) {
        customerDao.addCustomer(customer);
    }

    @Override
    public Customer getCustomerById(int customerId) {
        return customerDao.getCustomerById(customerId);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerDao.getAllCustomers();
    }

    public Customer getCustomerByUsername(String username){
        return customerDao.getCustomerByUsername(username);

    }
}
