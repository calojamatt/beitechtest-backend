/**
 * Development and Technologies Solutions S.A.S
 * beitechtest-backend
 * ICustomerService.java
 * <p>
 * Derechos de Autor 2015-2019 D&TS ©
 * Todos los Derechos Reservados.
 */

package com.beitechtest.businesslogic.service;

import com.beitechtest.data.entity.Customer;

import java.util.List;

/**
 * @author: CarlosMatt
 * @version: 1.0.1
 * @created: 04/07/2019 3:58 PM
 */
public interface ICustomerService {
    List<Customer> findAll();
    Customer findByCustomerId(Integer customerId);
}
