package com.manoj.emusicstore.dao;

import com.manoj.emusicstore.model.Product;

import java.util.List;

/**
 * Created by Manoj Baral on 12/29/2016.
 */
public interface ProductDao {

    List<Product> getProductList ();

    Product getProductById(int id);


    void addProduct(Product product);

    void editProduct(Product product);

    void deleteProduct(Product product);
}
