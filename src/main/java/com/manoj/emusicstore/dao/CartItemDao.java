package com.manoj.emusicstore.dao;

import com.manoj.emusicstore.model.Cart;
import com.manoj.emusicstore.model.CartItem;

/**
 * Created by Manoj Baral on 4/13/2017.
 */
public interface CartItemDao {
    void addCartItem(CartItem cartItem);

    void removeCartItem (CartItem cartItem);

    void removeAllCartItems (Cart cart);

    CartItem getCartItemByProductId (int productId);
}
