package com.manoj.emusicstore.service;

import com.manoj.emusicstore.model.Product;

import java.util.List;

/**
 * Created by Manoj Baral on 3/11/2017.
 */
public interface ProductService {

    List<Product> getProductList ();


    Product getProductById(int id);


    void addProduct(Product product);

    void editProduct(Product product);

    void deleteProduct(Product product);
}


