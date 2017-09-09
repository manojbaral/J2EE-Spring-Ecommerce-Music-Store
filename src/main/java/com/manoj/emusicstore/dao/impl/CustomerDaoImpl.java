package com.manoj.emusicstore.dao.impl;

import com.manoj.emusicstore.dao.CustomerDao;
import com.manoj.emusicstore.model.Authorities;
import com.manoj.emusicstore.model.Cart;
import com.manoj.emusicstore.model.Customer;
import com.manoj.emusicstore.model.Users;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Manoj Baral on 4/12/2017.
 */

@Repository
@Transactional
public class CustomerDaoImpl implements CustomerDao{

    @Autowired
    private SessionFactory sessionFactory;

    public void addCustomer(Customer customer){
        Session session=sessionFactory.getCurrentSession();

        customer.getBillingAddress().setCustomer(customer);
        customer.getShippingAddress().setCustomer(customer);

        session.saveOrUpdate(customer);
        session.saveOrUpdate(customer.getBillingAddress());
        session.saveOrUpdate(customer.getShippingAddress());

        //creating new users for customer via hibernate that save on database
        Users newUser=new Users();
        newUser.setUsername(customer.getUsername());
        newUser.setPassword(customer.getPassword());
        newUser.setEnabled(true);
        newUser.setCustomerId(customer.getCustomerId());
        session.saveOrUpdate(newUser);

        //Creating new Authority for custoer via hibernate that save on database
        Authorities newAuthority=new Authorities();
        newAuthority.setUsername(customer.getUsername());
        newAuthority.setAuthority("ROLE_USER");
        session.saveOrUpdate(newAuthority);

        //creating new Cart
        Cart newCart=new Cart();
        newCart.setCustomer(customer);
        customer.setCart(newCart);
        session.saveOrUpdate(customer);
        session.saveOrUpdate(newCart);

        session.flush();
    }

    public Customer getCustomerById(int customerId){
        Session session=sessionFactory.getCurrentSession();
        return (Customer) session.get(Customer.class,customerId);
    }

    public List<Customer> getAllCustomers(){
        Session session=sessionFactory.getCurrentSession();
        Query query=session.createQuery("from Customer");
        List<Customer> customerList=query.list();
        return customerList;
    }

    public Customer getCustomerByUsername(String username){
        Session session=sessionFactory.getCurrentSession();
        Query query=session.createQuery("from Customer where username=?");
        query.setString(0,username);

        return (Customer) query.uniqueResult();

    }

}
