package com.manoj.emusicstore.controller.admin;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.manoj.emusicstore.model.Product;
import com.manoj.emusicstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.naming.Binding;
import javax.persistence.Id;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Manoj Baral on 4/12/2017.
 */

@Controller
@RequestMapping("/admin")
public class AdminProduct {

    private Path path;

    @Autowired
    private ProductService productService;

    //Add Product Functionality
    @RequestMapping("/product/addProduct")
    public String addProduct(Model model) {
        Product product = new Product();
        product.setProductCategory("Instrument");
        product.setProductCondition("New");
        product.setProductStatus("Active");

        model.addAttribute("product", product);
        return "addProduct";
    }

    //Post Method for Add Product
    @RequestMapping(value = "/product/addProduct", method = RequestMethod.POST)
    public String addProductPost(@Valid @ModelAttribute("product") Product product, BindingResult result,
                                 HttpServletRequest request) {
        if (result.hasErrors()) {
            return "addProduct";
        }
        productService.addProduct(product);

        //handle image and product image
        MultipartFile productImage = product.getProductImage();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\" + product.getProductId() + ".png");

        if (productImage != null && !productImage.isEmpty()) {
            try {
                productImage.transferTo(new File(path.toString()));
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Product image saving failed.", e);
            }
        }

        productService.editProduct(product);

        return "redirect:/admin/productInventory";
    }

//    //Method to handle delete product
//    @RequestMapping("/product/deleteProduct/{id}")
//    public String deleteProduct(@PathVariable int id, Model model, HttpServletRequest request) {
//        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
//        path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\" + id + ".png");
//
//        if (Files.exists(path)) {
//            try {
//                Files.delete(path);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//        Product product = productService.getProductById(id);
//        productService.deleteProduct(product);
//
//        return "redirect:/admin/productInventory";
//    }

    //Edit Product Functionality
    @RequestMapping("/product/editProduct/{id}")
    public String editProduct(@PathVariable("id") int id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "editProduct";

    }

    //comment
    //Post Method for Add Product
    @RequestMapping(value = "/product/editProduct", method = RequestMethod.POST)
    public String editProductPost(@Valid @ModelAttribute("product") Product product, BindingResult result,
                                  HttpServletRequest request) {
        if (result.hasErrors()) {
            return "editProduct";
        }

        //handle image and product image
        MultipartFile productImage = product.getProductImage();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\" + product.getProductId() + ".png");

        if (productImage != null && !productImage.isEmpty()) {
            try {
                productImage.transferTo(new File(path.toString()));
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Product image saving failed.", e);
            }
        }

        productService.editProduct(product);

        return "redirect:/admin/productInventory";
    }

    //Method to handle delete product
    @RequestMapping("/product/deleteProduct/{id}")
    public String deleteProduct(@PathVariable int id, Model model, HttpServletRequest request) {
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\" + id + ".png");

        if (Files.exists(path)) {
            try {
                Files.delete(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Product product = productService.getProductById(id);
        productService.deleteProduct(product);

        return "redirect:/admin/productInventory";
    }
}






