package com.manoj.emusicstore.dao;

import com.manoj.emusicstore.model.Cart;

import java.io.IOException;

/**
 * Created by Manoj Baral on 2/23/2017.
 */
public interface CartDao {
    Cart getCartById(int cartId);

    Cart validate(int cartId) throws IOException;
    void update(Cart cart);
}
