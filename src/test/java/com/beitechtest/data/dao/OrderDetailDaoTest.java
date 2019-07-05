package com.beitechtest.data.dao;

import com.beitechtest.app.BeitechtestcammApplication;
import com.beitechtest.data.entity.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BeitechtestcammApplication.class)
public class OrderDetailDaoTest {

    @Autowired
    OrderDetailDao orderDetailDao;

    @Test
    public void findAll() throws Exception {
        List<OrderDetail> orderDetailList = orderDetailDao.findAll();
        Assert.assertTrue(orderDetailList.size() >= 0);
    }

    @Test
    public void findByOrderDetailId() throws Exception {
        Integer orderDetailId = 178;
        OrderDetail orderDetail = orderDetailDao.findByOrderDetailId(orderDetailId);
        Assert.assertNotNull("OrderDetail Is Null", orderDetail);
        Assert.assertNotNull(orderDetail.getOrderId());
        Assert.assertNotNull(orderDetail.getProductId());
    }

    @Test
    public void findByOrderId() throws Exception {
        Integer orderId = 83;
        List<OrderDetail> orderDetailList = orderDetailDao.findByOrderId(orderId);
        Assert.assertNotNull("OrderDetail Is Null", orderDetailList);
        Assert.assertTrue(orderDetailList.size() >= 0);
    }

    @Test
    public void findByProductId() throws Exception {
        Integer productId = 21;
        List<OrderDetail> orderDetailList = orderDetailDao.findByProductId(productId);
        Assert.assertNotNull("OrderDetail Is Null", orderDetailList);
        Assert.assertTrue(orderDetailList.size() >= 0);
    }

    @Test
    public void findByProductDescription() throws Exception {
        String productDescription = "Producto 1 Prueba";
        List<OrderDetail> orderDetailList = orderDetailDao.findByProductDescription(productDescription);
        Assert.assertNotNull("OrderDetail Is Null", orderDetailList);
        Assert.assertTrue(orderDetailList.size() >= 0);
    }

    @Test
    public void findByPrice() throws Exception {
        double price = 30000;
        List<OrderDetail> orderDetailList = orderDetailDao.findByPrice(price);
        Assert.assertNotNull("OrderDetail Is Null", orderDetailList);
        Assert.assertTrue(orderDetailList.size() >= 0);
    }

    @Test
    public void findByQuantity() throws Exception {
        int quentity = 1;
        List<OrderDetail> orderDetailList = orderDetailDao.findByQuantity(quentity);
        Assert.assertNotNull("OrderDetail Is Null", orderDetailList);
        Assert.assertTrue(orderDetailList.size() >= 0);
    }

}