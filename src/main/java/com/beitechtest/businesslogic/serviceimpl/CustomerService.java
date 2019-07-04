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
import com.beitechtest.data.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: CarlosMatt
 * @version: 1.0.1
 * @created: 04/07/2019 3:59 PM
 */
@Service
public class CustomerService implements ICustomerService {

    @Autowired
    CustomerDao customerDao;

    @Override
    public List<Customer> findAll() {
        return customerDao.findAll();
    }

    @Override
    public Customer findByCustomerId(Integer customerId) {
        return customerDao.findByCustomerId(customerId);
    }
}
