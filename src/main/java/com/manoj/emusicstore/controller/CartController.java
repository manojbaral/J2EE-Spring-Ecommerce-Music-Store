package com.manoj.emusicstore.controller;

import com.manoj.emusicstore.model.Customer;
import com.manoj.emusicstore.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Manoj Baral on 4/13/2017.
 */

@Controller
@RequestMapping("/customer/cart")
public class CartController {

    //@Autowired
    //private CartService cartService;

    @Autowired
    private CustomerService customerService;

    //get cart method for users
    @RequestMapping
    public String getCart(@AuthenticationPrincipal User activeUser) {
        Customer customer = customerService.getCustomerByUsername(activeUser.getUsername());

        //create cart
        int cartId = customer.getCart().getCartId();
        return "redirect:/customer/cart/" + cartId;
    }

    //method for cartid to get
    @RequestMapping( "/{cartId}")
    public String getCartRedirect(@PathVariable(value = "cartId") int cartId, Model model) {
        model.addAttribute("cartId", cartId);

        return "cart";
    }
}
