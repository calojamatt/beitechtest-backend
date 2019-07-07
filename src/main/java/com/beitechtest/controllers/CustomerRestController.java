/**
 * beitechtest-backend
 * CustomerRestController.java
 * <p>
 * Derechos de Autor 2015-2019 D&TS ©
 * Todos los Derechos Reservados.
 */
package com.beitechtest.controllers;

import com.beitechtest.businesslogic.service.ICustomerService;
import com.beitechtest.data.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: CarlosMatt
 * @version: 1.0.1
 * @created: 04/07/2019 4:01 PM
 */
@RestController
public class CustomerRestController {

    @Autowired
    ICustomerService customerService;

    @GetMapping(value = "/beitechtest/customer/listAllCustomer")
    public List<Customer> listAllCustomer() {
        return customerService.findAll();
    }

}
