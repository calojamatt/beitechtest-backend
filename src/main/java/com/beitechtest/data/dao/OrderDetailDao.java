/**
 * beitechtest-backend
 * OrderDetailDao.java
 * <p>
 * Derechos de Autor 2015-2019 D&TS ©
 * Todos los Derechos Reservados.
 */
package com.beitechtest.data.dao;

import com.beitechtest.data.entity.OrderDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

/**
 * @author: CarlosMatt
 * @version: 1.0.1
 * @created: 04/07/2019 3:33 PM
 */
@Transactional
@Repository
public class OrderDetailDao implements IOrderDetailDao {

    private SessionFactory sessionFactory;

    @Autowired
    public OrderDetailDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * Return a list of All OrderDetail
     *
     * @return <code>List<OrderDetail></code>
     */
    @Override
    public List<OrderDetail> findAll() {
        Session session = this.sessionFactory.getCurrentSession();
        TypedQuery<OrderDetail> query = session.getNamedQuery("OrderDetail.findAll");
        return query.getResultList();
    }

    /**
     * Return an OrderDetail
     *
     * @return <code>OrderDetail</code>
     */
    @Override
    public OrderDetail findByOrderDetailId(Integer orderDetailId) {
        Session session = this.sessionFactory.getCurrentSession();
        TypedQuery<OrderDetail> query = session.getNamedQuery("OrderDetail.findByOrderDetailId");
        query.setParameter("orderDetailId", orderDetailId);
        return query.getSingleResult();
    }

    /**
     * Return a list of All OrderDetail
     *
     * @param orderId <pre>@code Integer</pre>
     *
     * @return <code>List<OrderDetail></code>
     */
    @Override
    public List<OrderDetail> findByOrderId(Integer orderId) {
        Session session = this.sessionFactory.getCurrentSession();
        TypedQuery<OrderDetail> query = session.getNamedQuery("OrderDetail.findByOrderId");
        query.setParameter("orderId", orderId);
        return query.getResultList();
    }

    /**
     * Return a list of All OrderDetail
     *
     * @param productId <pre>@code Integer</pre>
     *
     * @return <code>List<OrderDetail></code>
     */
    @Override
    public List<OrderDetail> findByProductId(Integer productId) {
        Session session = this.sessionFactory.getCurrentSession();
        TypedQuery<OrderDetail> query = session.getNamedQuery("OrderDetail.findByProductId");
        query.setParameter("productId", productId);
        return query.getResultList();
    }

    /**
     * Return a list of All OrderDetail
     *
     * @param productDescription <pre>@code String</pre>
     *
     * @return <code>List<OrderDetail></code>
     */
    @Override
    public List<OrderDetail> findByProductDescription(String productDescription) {
        Session session = this.sessionFactory.getCurrentSession();
        TypedQuery<OrderDetail> query = session.getNamedQuery("OrderDetail.findByProductDescription");
        query.setParameter("productDescription", productDescription);
        return query.getResultList();
    }

    /**
     * Return a list of All OrderDetail
     *
     * @param price <pre>@code double</pre>
     *
     * @return <code>List<OrderDetail></code>
     */
    @Override
    public List<OrderDetail> findByPrice(double price) {
        Session session = this.sessionFactory.getCurrentSession();
        TypedQuery<OrderDetail> query = session.getNamedQuery("OrderDetail.findByPrice");
        query.setParameter("price", price);
        return query.getResultList();
    }

    /**
     * Return a list of All OrderDetail
     *
     * @param quantity <pre>@code int</pre>
     *
     * @return <code>List<OrderDetail></code>
     */
    @Override
    public List<OrderDetail> findByQuantity(int quantity) {
        Session session = this.sessionFactory.getCurrentSession();
        TypedQuery<OrderDetail> query = session.getNamedQuery("OrderDetail.findByQuantity");
        query.setParameter("quantity", quantity);
        return query.getResultList();
    }

    /**
     * Returns orderDetailId if data is saved successfully, elsewhere returns 0
     *
     * @param orderDetail <pre>@code OrderDetail</pre>
     *
     * @return <code>Integer</code>
     */
    @Override
    public Integer saveOrderDetail(OrderDetail orderDetail) {
        Session session = this.sessionFactory.getCurrentSession();
        return (Integer) session.save(orderDetail);
    }
}
