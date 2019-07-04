/**
 * Development and Technologies Solutions S.A.S
 * beitechtest-backend
 * IOrderDao.java
 * <p>
 * Derechos de Autor 2015-2019 D&TS ©
 * Todos los Derechos Reservados.
 */

package com.beitechtest.data.dao;

import com.beitechtest.data.entities.Order;

import java.util.Date;
import java.util.List;

/**
 * @author: CarlosMatt
 * @version: 1.0.1
 * @created: 04/07/2019 3:13 PM
 */
public interface IOrderDao {
    List<Order> findAll();
    List<Order> findCustomerOrderByDate(Integer customerId, Date startDate, Date endDate);
    Order findByOrderId(Integer orderId);
    Order findByCreationDate(Date creationDate);
    Order findByDeliveryAddress(String deliveryAddress);
    Order findByTotal(double total);
}
