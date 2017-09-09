package com.manoj.emusicstore.service.impl;

import com.manoj.emusicstore.dao.CartDao;
import com.manoj.emusicstore.model.Cart;
import com.manoj.emusicstore.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Manoj Baral on 4/13/2017.
 */
@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartDao cartDao;

    @Override
    public Cart getCartById(int cartId) {
        return cartDao.getCartById(cartId);
    }

    @Override
    public void update(Cart cart) {
        cartDao.update(cart);

    }
}
