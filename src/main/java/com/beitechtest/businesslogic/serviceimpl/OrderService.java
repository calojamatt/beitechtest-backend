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
import com.beitechtest.data.dto.OrderCustomerDTO;
import com.beitechtest.data.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

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
    public List<OrderCustomerDTO> findOrderByCustomerAndDate(Integer customerId, Date startDate, Date endDate) {
        List<Order> orderList = orderDao.findCustomerOrderByDate(customerId, startDate, endDate);
        List<OrderCustomerDTO> orderCustomerDTOList = new ArrayList<>();
        orderList.forEach(order -> {
            Set<String> orderListProducts = new HashSet<>();
            OrderCustomerDTO orderCustomerDTO = new OrderCustomerDTO();
            orderCustomerDTO.setCreationDate(order.getCreationDate());
            orderCustomerDTO.setOrderId(order.getOrderId());
            orderCustomerDTO.setDeliveryAddress(order.getDeliveryAddress());
            orderCustomerDTO.setTotal(order.getTotal());
            order.getOrderDetailList().forEach(od -> {
                StringBuilder orderProducts = new StringBuilder();
                orderProducts.append(od.getQuantity()).append(" x ")
                        .append(od.getProductId().getName());
                orderListProducts.add(orderProducts.toString());
            });
            orderCustomerDTO.setProducts(orderListProducts.toString()
                    .replace("[","")
                    .replace("]",""));
            orderCustomerDTOList.add(orderCustomerDTO);
        });
        return orderCustomerDTOList;
    }

    @Override
    public Integer saveOrder(Order order) {
        if (order.getOrderDetailList().size() > 0 && order.getOrderDetailList().size() <= 5) {
            return orderDao.save(order);
        } else if (order.getOrderDetailList().size() > 5) {
            return -1;
        }
        return 0;
    }
}
