/**
 * beitechtest-backend
 * ProductDao.java
 * <p>
 * Derechos de Autor 2015-2019 D&TS ©
 * Todos los Derechos Reservados.
 */
package com.beitechtest.data.dao;

import com.beitechtest.data.entity.Product;
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
 * @created: 04/07/2019 3:27 PM
 */
@Transactional
@Repository
public class ProductDao implements IProductDao {

    private SessionFactory sessionFactory;

    @Autowired
    public ProductDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * Return a list of All Product
     *
     * @return <code>List<Product></code>
     */
    @Override
    public List<Product> findAll() {
        Session session = this.sessionFactory.getCurrentSession();
        TypedQuery<Product> query = session.getNamedQuery("Product.findAll");
        return query.getResultList();
    }

    /**
     * Return a Product
     *
     * @param productId <pre>@code Integer</pre>
     *
     * @return <code>Product</code>
     */
    @Override
    public Product findByProductId(Integer productId) {
        Session session = this.sessionFactory.getCurrentSession();
        TypedQuery<Product> query = session.getNamedQuery("Product.findByProductId");
        query.setParameter("productId", productId);
        return query.getSingleResult();
    }

    /**
     * Return a list of Products
     *
     * @param name <pre>@code String</pre>
     *
     * @return <code>List<Product></code>
     */
    @Override
    public List<Product> findByName(String name) {
        Session session = this.sessionFactory.getCurrentSession();
        TypedQuery<Product> query = session.getNamedQuery("Product.findByName");
        query.setParameter("name", name);
        return query.getResultList();
    }

    /**
     * Returns a list of Products
     *
     * @param productDescription <pre>@code String</pre>
     *
     * @return <code>List<Product></code>
     */
    @Override
    public List<Product> findByProductDescription(String productDescription) {
        Session session = this.sessionFactory.getCurrentSession();
        TypedQuery<Product> query = session.getNamedQuery("Product.findByProductDescription");
        query.setParameter("productDescription", productDescription);
        return query.getResultList();
    }

    /**
     * Returns a list of Products
     *
     * @param price <pre>@code double</pre>
     *
     * @return <code>List<Product></code>
     */
    @Override
    public List<Product> findByPrice(double price) {
        Session session = this.sessionFactory.getCurrentSession();
        TypedQuery<Product> query = session.getNamedQuery("Product.findByPrice");
        query.setParameter("price", price);
        return query.getResultList();
    }
}
