package com.manoj.emusicstore.service.impl;

import com.manoj.emusicstore.dao.CartDao;
import com.manoj.emusicstore.dao.CartItemDao;
import com.manoj.emusicstore.model.Cart;
import com.manoj.emusicstore.model.CartItem;
import com.manoj.emusicstore.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Manoj Baral on 4/13/2017.
 */

@Service
public class CartItemServiceImpl implements CartItemService {

    @Autowired
    private CartItemDao cartItemDao;

    @Override
    public void addCartItem(CartItem cartItem) {
        cartItemDao.addCartItem(cartItem);

    }

    @Override
    public void removeCartItem(CartItem cartItem) {
        cartItemDao.removeCartItem(cartItem);

    }

    @Override
    public void removeAllCartItems(Cart cart) {
        cartItemDao.removeAllCartItems(cart);

    }

    @Override
    public CartItem getCartItemByProductId(int productId) {
        return cartItemDao.getCartItemByProductId(productId);

    }
}
