/**
 * beitechtest-backend
 * OrderDao.java
 * <p>
 * Derechos de Autor 2015-2019 D&TS ©
 * Todos los Derechos Reservados.
 */
package com.beitechtest.data.dao;

import com.beitechtest.data.entity.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

/**
 * @author: CarlosMatt
 * @version: 1.0.1
 * @created: 04/07/2019 3:17 PM
 */
@Transactional
@Repository
public class OrderDao implements IOrderDao {

    private SessionFactory sessionFactory;

    @Autowired
    public OrderDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * Return a list of All Order
     *
     * @return <code>List<Order></code>
     */
    @Override
    public List<Order> findAll() {
        Session session = this.sessionFactory.getCurrentSession();
        TypedQuery<Order> query = session.getNamedQuery("Order.findAll");
        return query.getResultList();
    }

    /**
     * Returns a list of data from Order
     *
     * @param customerId <pre>@code Integer</pre>
     * @param startDate <pre>@code Date</pre> startDate must be minor then endDate
     * @param endDate <pre>@code Date</pre> endDate must be greater then startDate
     *
     * @return <code>List<OrderCustomerDTO></code>
     */
    @Override
    public List<Order> findCustomerOrderByDate(Integer customerId, Date startDate, Date endDate) {
        Session session = this.sessionFactory.getCurrentSession();
        TypedQuery<Order> query = session.getNamedQuery("Order.findCustomerOrderByDate");
        query.setParameter("customerId", customerId);
        query.setParameter("startDate", new java.sql.Date(startDate.getTime()));
        query.setParameter("endDate", new java.sql.Date(endDate.getTime()));
        return query.getResultList();
    }

    /**
     * Return an Order
     *
     * @param orderId <pre>@code Integer</pre>
     *
     * @return <code>Order</code>
     */
    @Override
    public Order findByOrderId(Integer orderId) {
        Session session = this.sessionFactory.getCurrentSession();
        TypedQuery<Order> query = session.getNamedQuery("Order.findByOrderId");
        query.setParameter("orderId", orderId);
        return query.getSingleResult();
    }

    /**
     * Returns a list of Order
     *
     * @param creationDate <pre>@code Date</pre>
     *
     * @return <code>List<Order></code>
     */
    @Override
    public List<Order> findByCreationDate(Date creationDate) {
        Session session = this.sessionFactory.getCurrentSession();
        TypedQuery<Order> query = session.getNamedQuery("Order.findByCreationDate");
        query.setParameter("creationDate", new java.sql.Date(creationDate.getTime()));
        return query.getResultList();
    }

    /**
     * Returns a list of Order
     *
     * @param deliveryAddress <pre>@code String</pre>
     *
     * @return <code>List<Order></code>
     */
    @Override
    public List<Order> findByDeliveryAddress(String deliveryAddress) {
        Session session = this.sessionFactory.getCurrentSession();
        TypedQuery<Order> query = session.getNamedQuery("Order.findByDeliveryAddress");
        query.setParameter("deliveryAddress", deliveryAddress);
        return query.getResultList();
    }

    /**
     * Returns a list of Order
     *
     * @param total <pre>@code double</pre>
     *
     * @return <code>List<Order></code>
     */
    @Override
    public List<Order> findByTotal(double total) {
        Session session = this.sessionFactory.getCurrentSession();
        TypedQuery<Order> query = session.getNamedQuery("Order.findByTotal");
        query.setParameter("total", total);
        return query.getResultList();
    }

    /**
     * Returns orderId if data is saved successfully, elsewhere returns 0
     *
     * @param order <pre>@code Order</pre>
     *
     * @return <code>Integer</code>
     */
    @Override
    public Integer save(Order order) {
        Session session = this.sessionFactory.getCurrentSession();
        return (Integer) session.save(order);
    }
}
