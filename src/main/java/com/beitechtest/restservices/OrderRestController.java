/**
 * Development and Technologies Solutions S.A.S
 * beitechtest-backend
 * OrderRestController.java
 * <p>
 * Derechos de Autor 2015-2019 D&TS ©
 * Todos los Derechos Reservados.
 */
package com.beitechtest.restservices;

import com.beitechtest.businesslogic.service.IOrderService;
import com.beitechtest.data.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @author: CarlosMatt
 * @version: 1.0.1
 * @created: 04/07/2019 4:04 PM
 */
@RestController
public class OrderRestController {

    @Autowired
    IOrderService orderService;

    @GetMapping(value = "/beitechtest/listCustomerOrder/{customerId}/{startDate}/{endDate}")
    public ResponseBody listCustomerOrdersByDate(@PathVariable("customerId") Integer customerId,
                                 @PathVariable("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE,
                                            pattern = "yyyy-MM-dd") Date startDate,
                                 @PathVariable("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE,
                                         pattern = "yyyy-MM-dd") Date endDate ) {
        return (ResponseBody) orderService.findCustomerOrderByDate(customerId, startDate, endDate);
    }

    @GetMapping(value = "/beitechtest/listAllCustomersOrders")
    public ResponseEntity listAllCustomersOrders() {
        return (ResponseEntity) orderService.findAll();
    }

    @PostMapping(value = "/beitechtest/saveOrder")
    public ResponseEntity saveOrder(@RequestBody Order order) {
        orderService.saveOrder(order);
        return null;
    }
}
