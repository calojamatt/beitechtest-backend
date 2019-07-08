/**
 * beitechtest-backend
 * OrderDetailService.java
 * <p>
 * Derechos de Autor 2015-2019 D&TS ©
 * Todos los Derechos Reservados.
 */
package com.beitechtest.businesslogic.serviceimpl;

import com.beitechtest.businesslogic.service.IOrderDetailService;
import com.beitechtest.data.dao.OrderDetailDao;
import com.beitechtest.data.entity.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author: CarlosMatt
 * @version: 1.0.1
 * @created: 04/07/2019 4:06 PM
 */
@Transactional
@Service
public class OrderDetailService implements IOrderDetailService {

    @Autowired
    private OrderDetailDao orderDetailDao;

    /**
     * Returns a list of All OrderDetail
     *
     * @return <code>List<OrderDetail></code>
     */
    @Override
    public List<OrderDetail> findAll() {
        return orderDetailDao.findAll();
    }

    /**
     * Return an OrderDetail
     *
     * @param orderDetailId <pre>@code Integer</pre>
     *
     * @return <code>OrderDetail</code>
     */
    @Override
    public OrderDetail findByOrderDetailId(Integer orderDetailId) {
        return orderDetailDao.findByOrderDetailId(orderDetailId);
    }

    /**
     * Return a List of OrderDetail
     *
     * @param orderId <pre>@code Integer</pre>
     *
     * @return <code>List<OrderDetail></code>
     */
    @Override
    public List<OrderDetail> findByOrderId(Integer orderId) {
        return orderDetailDao.findByOrderId(orderId);
    }

}
