/**
 * beitechtest-backend
 * CustomerRestController.java
 * <p>
 * Derechos de Autor 2015-2019 D&TS ©
 * Todos los Derechos Reservados.
 */
package com.beitechtest.restservices;

import com.beitechtest.businesslogic.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: CarlosMatt
 * @version: 1.0.1
 * @created: 04/07/2019 4:01 PM
 */
@RestController
public class CustomerRestController {

    @Autowired
    ICustomerService customerService;
}
