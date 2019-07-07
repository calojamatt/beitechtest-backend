package com.beitechtest.businesslogic.serviceimpl;

import com.beitechtest.app.BeitechtestcammApplication;
import com.beitechtest.data.entity.OrderDetail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BeitechtestcammApplication.class)
public class OrderDetailServiceTest {

    @Autowired
    OrderDetailService orderDetailService;

    @Test
    public void findAll() throws Exception {
        assertTrue("OrderDetail List Is empty", orderDetailService.findAll().size() > 0);
    }

    @Test
    public void findByOrderDetailId() throws Exception {
        Integer orderDetailid = 184;
        OrderDetail orderDetail = orderDetailService.findByOrderDetailId(orderDetailid);
        assertEquals(orderDetailid, orderDetail.getOrderDetailId());
    }

    @Test
    public void findByOrderId() throws Exception {
        Integer orderid = 83;
        List<OrderDetail> orderDetailList = orderDetailService.findByOrderId(orderid);
        assertTrue(orderDetailList.size() > 0);
        assertEquals(orderid, orderDetailList.get(0).getOrderId().getOrderId());
    }

}