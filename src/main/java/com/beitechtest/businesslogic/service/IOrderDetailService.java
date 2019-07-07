/**
 * beitechtest-backend
 * IOrderDetailService.java
 * <p>
 * Derechos de Autor 2015-2019 D&TS ©
 * Todos los Derechos Reservados.
 */
package com.beitechtest.businesslogic.service;

import com.beitechtest.data.entity.OrderDetail;

import java.util.List;

/**
 * @author: CarlosMatt
 * @version: 1.0.1
 * @created: 04/07/2019 4:05 PM
 */
public interface IOrderDetailService {
    List<OrderDetail> findAll();
    OrderDetail findByOrderDetailId(Integer orderDetailId);
    List<OrderDetail> findByOrderId(Integer orderId);
}
