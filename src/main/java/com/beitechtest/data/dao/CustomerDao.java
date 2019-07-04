/**
 * beitechtest-backend
 * CustomerDao.java
 * <p>
 * Derechos de Autor 2015-2019 D&TS ©
 * Todos los Derechos Reservados.
 */
package com.beitechtest.data.dao;

import com.beitechtest.data.entities.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * @author: CarlosMatt
 * @version: 1.0.1
 * @created: 04/07/2019 3:02 PM
 */
@Repository
public class CustomerDao implements ICustomerDao {

    private SessionFactory  sessionFactory;

    @Autowired
    public CustomerDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Customer> findAll() {
        Session session = this.sessionFactory.getCurrentSession();
        TypedQuery<Customer> query = session.getNamedQuery("Customer.findAll");
        return query.getResultList();
    }

    @Override
    public Customer findByCustomerId(Integer customerId) {
        Session session = this.sessionFactory.getCurrentSession();
        TypedQuery<Customer> query = session.getNamedQuery("Customer.findByCustomerId");
        query.setParameter("id", customerId);
        return query.getSingleResult();
    }

    @Override
    public Customer findByName(String name) {
        Session session = this.sessionFactory.getCurrentSession();
        TypedQuery<Customer> query = session.getNamedQuery("Customer.findByName");
        query.setParameter("name", name);
        return query.getSingleResult();
    }

    @Override
    public Customer findByEmail(String email) {
        Session session = this.sessionFactory.getCurrentSession();
        TypedQuery<Customer> query = session.getNamedQuery("Customer.findByEmail");
        query.setParameter("email", email);
        return query.getSingleResult();
    }
}
