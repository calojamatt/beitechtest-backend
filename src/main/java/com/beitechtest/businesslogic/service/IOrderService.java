/**
 * Development and Technologies Solutions S.A.S
 * beitechtest-backend
 * IOrderService.java
 * <p>
 * Derechos de Autor 2015-2019 D&TS ©
 * Todos los Derechos Reservados.
 */

package com.beitechtest.businesslogic.service;

import com.beitechtest.data.entities.Order;

import java.util.Date;
import java.util.List;

/**
 * @author: CarlosMatt
 * @version: 1.0.1
 * @created: 04/07/2019 4:02 PM
 */
public interface IOrderService {
    List<Order> findAll();
    Order findByOrderId(Integer orderId);
    List<Order> findCustomerOrderByDate(Integer customerId, Date startDate, Date endDate);
    boolean saveOrder(Order order);
}
