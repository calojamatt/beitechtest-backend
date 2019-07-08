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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    private IOrderService orderService;


    /**
     * Returns a list of data of orders in json format
     *
     * @param customerId <pre>@code Integer</pre>
     * @param startDate <pre>@code Date</pre>
     * @param endDate <pre>@code Date</pre>
     *
     * @return <code>List<OrderCustomerDTO></code>
     */
    @GetMapping(value = "/beitechtest/order/listCustomerOrder/{customerId}/{startDate}/{endDate}")
    public List<OrderCustomerDTO> listOrdersByCustomerAndDate(@PathVariable("customerId") Integer customerId,
                              @PathVariable("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE,
                                            pattern = "yyyy-MM-dd") Date startDate,
                              @PathVariable("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE,
                                         pattern = "yyyy-MM-dd") Date endDate ) {
        return orderService.findOrderByCustomerAndDate(customerId, startDate, endDate);
    }

    /**
     * Returns orderId if data is saved successfully.
     * Returns -1 if quantity of product in the list in OrderDetail is greater than 5
     * or if is there any product that do not belongs to customer in the Order
     * Return 0 if the list in OrderDetal is null or empty
     *
     * @param orderJson <pre>@code String</pre>
     *
     * @return <code>ResponseEntity<Integer></code>
     */
    @PostMapping(value = "/beitechtest/order/saveOrder")
    public ResponseEntity<Integer> saveOrder(@RequestBody String orderJson) {
        Integer returnValue = null;
        try {
            returnValue = orderService.saveOrder(orderJson);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseEntity(returnValue, HttpStatus.CREATED);
    }
}
