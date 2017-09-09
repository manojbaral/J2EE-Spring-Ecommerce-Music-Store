package com.manoj.emusicstore.service.impl;

import com.manoj.emusicstore.dao.CustomerDao;
import com.manoj.emusicstore.dao.CustomerOrderDao;
import com.manoj.emusicstore.model.Cart;
import com.manoj.emusicstore.model.CartItem;
import com.manoj.emusicstore.model.CustomerOrder;
import com.manoj.emusicstore.service.CartService;
import com.manoj.emusicstore.service.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Manoj Baral on 4/17/2017.
 */

@Service
public class CustomerOrderServiceImpl implements CustomerOrderService {

    @Autowired
    private CustomerOrderDao customerOrderDao;

    @Autowired
    private CartService cartService;

    @Override
    public void addCustomerOrder(CustomerOrder customerOrder) {
        customerOrderDao.addCustomerOrder(customerOrder);

    }

    @Override
    public double getCustomerOrderGrandTotal(int cartId) {
        double grandTotal=0;
        Cart cart=cartService.getCartById(cartId);
        List<CartItem> cartItems=cart.getCartItems();

        //calculate grandtotal for carts
        for (CartItem item:cartItems){
            grandTotal=grandTotal + item.getTotalPrice();
        }

        return grandTotal;
    }
}
