package com.manoj.emusicstore.service;

import com.manoj.emusicstore.model.CustomerOrder;

/**
 * Created by Manoj Baral on 4/17/2017.
 */
public interface CustomerOrderService {

    //add customer order
    void addCustomerOrder(CustomerOrder customerOrder);

    //customer grand total
    double getCustomerOrderGrandTotal(int cartId);
}
