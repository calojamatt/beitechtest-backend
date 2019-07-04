/**
 * beitechtest-backend
 * ProductDao.java
 * <p>
 * Derechos de Autor 2015-2019 D&TS ©
 * Todos los Derechos Reservados.
 */
package com.beitechtest.data.dao;

import com.beitechtest.data.entities.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * @author: CarlosMatt
 * @version: 1.0.1
 * @created: 04/07/2019 3:27 PM
 */
@Repository
public class ProductDao implements IProductDao {

    private SessionFactory sessionFactory;

    @Autowired
    public ProductDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Product> findAll() {
        Session session = this.sessionFactory.getCurrentSession();
        TypedQuery<Product> query = session.getNamedQuery("Product.findAll");
        return query.getResultList();
    }

    @Override
    public List<Product> findByCustomerId(Integer customerId) {
        Session session = this.sessionFactory.getCurrentSession();
        TypedQuery<Product> query = session.getNamedQuery("Product.findByCustomerId");
        query.setParameter("customerId", customerId);
        return query.getResultList();
    }

    @Override
    public Product findByProductId(Integer productId) {
        Session session = this.sessionFactory.getCurrentSession();
        TypedQuery<Product> query = session.getNamedQuery("Product.findAll");
        query.setParameter("id", productId);
        return query.getSingleResult();
    }

    @Override
    public Product findByName(String name) {
        Session session = this.sessionFactory.getCurrentSession();
        TypedQuery<Product> query = session.getNamedQuery("Product.findAll");
        query.setParameter("name", name);
        return query.getSingleResult();
    }

    @Override
    public Product findByProductDescription(String productDescription) {
        Session session = this.sessionFactory.getCurrentSession();
        TypedQuery<Product> query = session.getNamedQuery("Product.findAll");
        query.setParameter("productDescription", productDescription);
        return query.getSingleResult();
    }

    @Override
    public Product findByPrice(double price) {
        Session session = this.sessionFactory.getCurrentSession();
        TypedQuery<Product> query = session.getNamedQuery("Product.findAll");
        query.setParameter("price", price);
        return query.getSingleResult();
    }
}
