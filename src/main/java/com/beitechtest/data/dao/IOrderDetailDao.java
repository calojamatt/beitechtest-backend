/**
 * Development and Technologies Solutions S.A.S
 * beitechtest-backend
 * IOrderDetailDao.java
 * <p>
 * Derechos de Autor 2015-2019 D&TS ©
 * Todos los Derechos Reservados.
 */
package com.beitechtest.data.dao;

import com.beitechtest.data.entity.OrderDetail;

import java.util.List;

/**
 * @author: CarlosMatt
 * @version: 1.0.1
 * @created: 04/07/2019 3:30 PM
 */
public interface IOrderDetailDao {
    List<OrderDetail> findAll();
    OrderDetail findByOrderDetailId(Integer orderDetailId);
    List<OrderDetail> findByOrderId(Integer orderId);
    List<OrderDetail> findByProductId(Integer productId);
    List<OrderDetail> findByProductDescription(String productDescription);
    List<OrderDetail> findByPrice(double price);
    List<OrderDetail> findByQuantity(int quantity);
    Integer saveOrderDetail(OrderDetail orderDetail);
}
