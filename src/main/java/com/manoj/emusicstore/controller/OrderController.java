package com.manoj.emusicstore.controller;

import com.manoj.emusicstore.model.Cart;
import com.manoj.emusicstore.model.Customer;
import com.manoj.emusicstore.model.CustomerOrder;
import com.manoj.emusicstore.service.CartService;
import com.manoj.emusicstore.service.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Manoj Baral on 4/17/2017.
 */

@Controller
public class OrderController {

    @Autowired
    private CartService cartService;

    @Autowired
    private CustomerOrderService customerOrderService;

    @RequestMapping("/order/{cartId}")
    public String createOrder(@PathVariable("cartId") int cartId){
        CustomerOrder customerOrder=new CustomerOrder();
        Cart cart=cartService.getCartById(cartId);
        customerOrder.setCart(cart);

        Customer customer=cart.getCustomer();
        customerOrder.setCustomer(customer);
        customerOrder.setShippingAdress(customer.getShippingAddress());
        customerOrder.setBillingAddress(customer.getBillingAddress());

        customerOrderService.addCustomerOrder(customerOrder);
        return "redirect:/checkout?cartId=" + cartId;

    }
}
