package com.manoj.emusicstore.dao.impl;

import com.manoj.emusicstore.dao.CustomerOrderDao;
import com.manoj.emusicstore.model.CustomerOrder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Manoj Baral on 4/17/2017.
 */

@Repository
@Transactional
public class CustomerOrderDaoImpl implements CustomerOrderDao {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public void addCustomerOrder(CustomerOrder customerOrder) {
        Session session=sessionFactory.getCurrentSession();
        session.saveOrUpdate(customerOrder);
        session.flush();

    }
}
