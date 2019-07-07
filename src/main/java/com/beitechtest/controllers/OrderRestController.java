/**
 * Development and Technologies Solutions S.A.S
 * beitechtest-backend
 * OrderRestController.java
 * <p>
 * Derechos de Autor 2015-2019 D&TS ©
 * Todos los Derechos Reservados.
 */
package com.beitechtest.controllers;

import com.beitechtest.businesslogic.service.IOrderService;
import com.beitechtest.data.dto.OrderCustomerDTO;
import com.beitechtest.data.entity.Order;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @author: CarlosMatt
 * @version: 1.0.1
 * @created: 04/07/2019 4:04 PM
 */
@RestController
public class OrderRestController {

    @Autowired
    IOrderService orderService;

    @GetMapping(value = "/beitechtest/order/listCustomerOrder/{customerId}/{startDate}/{endDate}")
    public List<OrderCustomerDTO> listOrdersByCustomerAndDate(@PathVariable("customerId") Integer customerId,
                              @PathVariable("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE,
                                            pattern = "yyyy-MM-dd") Date startDate,
                              @PathVariable("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE,
                                         pattern = "yyyy-MM-dd") Date endDate ) {
        return orderService.findOrderByCustomerAndDate(customerId, startDate, endDate);
    }

    @GetMapping(value = "/beitechtest/order/listAllOrders")
    public List<Order> listAllOrders() {
        return orderService.findAll();
    }

    @PostMapping(value = "/beitechtest/order/saveOrder")
    public ResponseEntity<Integer> saveOrder(@RequestBody Order order) {
        Integer returnValue = orderService.saveOrder(order);
        return new ResponseEntity(returnValue, HttpStatus.CREATED);
    }
}
