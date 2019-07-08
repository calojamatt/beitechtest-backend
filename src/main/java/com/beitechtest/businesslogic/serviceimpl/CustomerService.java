/**
 * beitechtest-backend
 * CustomerService.java
 * <p>
 * Derechos de Autor 2015-2019 D&TS ©
 * Todos los Derechos Reservados.
 */
package com.beitechtest.businesslogic.serviceimpl;

import com.beitechtest.businesslogic.service.ICustomerService;
import com.beitechtest.data.dao.CustomerDao;
import com.beitechtest.data.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author: CarlosMatt
 * @version: 1.0.1
 * @created: 04/07/2019 3:59 PM
 */
@Transactional
@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private CustomerDao customerDao;

    /**
     * Returns a list of All customers
     *
     * @return <code>List<Customer></code>
     */
    @Override
    public List<Customer> findAll() {
        return customerDao.findAll();
    }

    /**
     * Return a Customer
     *
     * @param customerId <pre>@code Integer</pre>
     *
     * @return <code>Customer</code>
     */
    @Override
    public Customer findByCustomerId(Integer customerId) {
        return customerDao.findByCustomerId(customerId);
    }
}
