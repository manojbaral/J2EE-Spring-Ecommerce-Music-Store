package com.manoj.emusicstore.service;

import com.manoj.emusicstore.model.Cart;

/**
 * Created by Manoj Baral on 4/13/2017.
 */
public interface CartService {

    Cart getCartById(int cartId);
     void update(Cart cart);
}
