/**
 * beitechtest-backend
 * OrderDao.java
 * <p>
 * Derechos de Autor 2015-2019 D&TS ©
 * Todos los Derechos Reservados.
 */
package com.beitechtest.data.dao;

import com.beitechtest.data.entities.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

/**
 * @author: CarlosMatt
 * @version: 1.0.1
 * @created: 04/07/2019 3:17 PM
 */
@Repository
public class OrderDao implements IOrderDao {

    private SessionFactory sessionFactory;

    @Autowired
    public OrderDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Order> findAll() {
        Session session = this.sessionFactory.getCurrentSession();
        TypedQuery<Order> query = session.getNamedQuery("Order.findAll");
        return query.getResultList();
    }

    @Override
    public List<Order> findCustomerOrderByDate(Integer customerId, Date startDate, Date endDate) {
        Session session = this.sessionFactory.getCurrentSession();
        TypedQuery<Order> query = session.getNamedQuery("Order.findAll");
        query.setParameter("customerId", customerId);
        query.setParameter("startDate", new java.sql.Date(startDate.getTime()));
        query.setParameter("endDate", new java.sql.Date(endDate.getTime()));
        return query.getResultList();
    }

    @Override
    public Order findByOrderId(Integer orderId) {
        Session session = this.sessionFactory.getCurrentSession();
        TypedQuery<Order> query = session.getNamedQuery("Order.findByOrderId");
        query.setParameter("id", orderId);
        return query.getSingleResult();
    }

    @Override
    public Order findByCreationDate(Date creationDate) {
        Session session = this.sessionFactory.getCurrentSession();
        TypedQuery<Order> query = session.getNamedQuery("Order.findByCreationDate");
        query.setParameter("creationDate", new java.sql.Date(creationDate.getTime()));
        return query.getSingleResult();
    }

    @Override
    public Order findByDeliveryAddress(String deliveryAddress) {
        Session session = this.sessionFactory.getCurrentSession();
        TypedQuery<Order> query = session.getNamedQuery("Order.findByDeliveryAddress");
        query.setParameter("deliveryAddress", deliveryAddress);
        return query.getSingleResult();
    }

    @Override
    public Order findByTotal(double total) {
        Session session = this.sessionFactory.getCurrentSession();
        TypedQuery<Order> query = session.getNamedQuery("Order.findByTotal");
        query.setParameter("total", total);
        return query.getSingleResult();
    }
}
