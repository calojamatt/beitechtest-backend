/**
 * Development and Technologies Solutions S.A.S
 * beitechtest-backend
 * OrderService.java
 * <p>
 * Derechos de Autor 2015-2019 D&TS ©
 * Todos los Derechos Reservados.
 */
package com.beitechtest.businesslogic.serviceimpl;

import com.beitechtest.businesslogic.service.IOrderService;
import com.beitechtest.data.dao.OrderDao;
import com.beitechtest.data.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

/**
 * @author: CarlosMatt
 * @version: 1.0.1
 * @created: 04/07/2019 4:03 PM
 */
@Service
@Transactional
public class OrderService implements IOrderService {

    @Autowired
    OrderDao orderDao;

    @Override
    public List<Order> findAll() {
        return orderDao.findAll();
    }

    @Override
    public Order findByOrderId(Integer orderId) {
        return orderDao.findByOrderId(orderId);
    }

    @Override
    public List<Order> findCustomerOrderByDate(Integer customerId, Date startDate, Date endDate) {
        return orderDao.findCustomerOrderByDate(customerId, startDate, endDate);
    }

    @Override
    public boolean saveOrder(Order order) {
        return false;
    }
}
