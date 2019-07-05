/**
 * Development and Technologies Solutions S.A.S
 * beitechtest-backend
 * ICustomerDao.java
 * <p>
 * Derechos de Autor 2015-2019 D&TS ©
 * Todos los Derechos Reservados.
 */

package com.beitechtest.data.dao;

import com.beitechtest.data.entity.Customer;

import java.util.List;

/**
 * @author: CarlosMatt
 * @version: 1.0.1
 * @created: 04/07/2019 3:00 PM
 */
public interface ICustomerDao {
    List<Customer> findAll();
    Customer findByCustomerId(Integer customerId);
    Customer findByName(String name);
    Customer findByEmail(String email);
}
