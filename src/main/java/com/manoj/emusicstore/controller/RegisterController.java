package com.manoj.emusicstore.controller;

import com.manoj.emusicstore.model.BillingAddress;
import com.manoj.emusicstore.model.Customer;
import com.manoj.emusicstore.model.ShippingAddress;
import com.manoj.emusicstore.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Manoj Baral on 4/12/2017.
 */

@Controller
public class RegisterController {

    @Autowired
    private CustomerService customerService;

    //Register Controller
    @RequestMapping("/register")
    public String registerCustomer(Model model){

        Customer customer=new Customer();
        BillingAddress billingAddress=new BillingAddress();
        ShippingAddress shippingAddress=new ShippingAddress();
        customer.setBillingAddress(billingAddress);
        customer.setShippingAddress(shippingAddress);

        model.addAttribute("customer",customer);
        return "registerCustomer";
    }

    //Register Customer Post Method
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String registerCustomerPost(@Valid @ModelAttribute("customer") Customer customer, BindingResult result, Model model){

        //Customer validate
        if (result.hasErrors()){
            return "registerCustomer";
        }
        List<Customer> customerList = customerService.getAllCustomers();

        //Validae Email for customer
        for (int i=0; i<customerList.size(); i++) {
            if(customer.getCustomerEmail().equals(customerList.get(i).getCustomerEmail())) {
                model.addAttribute("emailMsg", "Email already exists.");

                return "registerCustomer";
            }

            //Validate username for customer
            if(customer.getUsername().equals(customerList.get(i).getUsername())) {

                model.addAttribute("usernameMsg", "Username already exists.");

                return "registerCustomer";
            }
        }


        customer.setEnabled(true);
        customerService.addCustomer(customer);

        return "registerCustomerSuccess";
    }
}
