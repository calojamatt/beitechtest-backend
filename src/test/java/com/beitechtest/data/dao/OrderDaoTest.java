package com.beitechtest.data.dao;

import com.beitechtest.app.BeitechtestcammApplication;
import com.beitechtest.data.entity.Customer;
import com.beitechtest.data.entity.Order;
import com.beitechtest.data.entity.OrderDetail;
import com.beitechtest.data.entity.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BeitechtestcammApplication.class)
public class OrderDaoTest {

    @Autowired
    OrderDao orderDao;

   @Test
    public void findAll() throws Exception {
        List<Order> orderList = orderDao.findAll();
        Assert.assertTrue("Order List Is null", orderList.size() >= 0);
    }

    @Test
    public void findCustomerOrderByDate() throws Exception {
        Integer customerId = 26;
        LocalDate sd = LocalDate.of(2019, 7,1);
        LocalDate ed = LocalDate.of(2019, 7,31);
        Date startDate = java.util.Date.from(sd.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        Date endDate = java.util.Date.from(ed.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        List<Order> orderList = orderDao.findCustomerOrderByDate(customerId, startDate, endDate);
        Assert.assertNotNull("Order Is Null", orderList);
        Assert.assertTrue("OrderDetail List Is null", orderList.size() >= 0);
    }

    @Test
    public void findByOrderId() throws Exception {
        Integer orderId = 83;
        Order order = orderDao.findByOrderId(orderId);
        Assert.assertNotNull("Order Is Null", order);
        Assert.assertTrue("OrderDetail List Is null", order.getOrderDetailSet().size() >= 0);
    }

    @Test
    public void findByCreationDate() throws Exception {
        LocalDate cd = LocalDate.of(2019, 7,5);
        Date creationDate = java.util.Date.from(cd.atStartOfDay()
                .atZone(ZoneId.systemDefault())
                .toInstant());
        List<Order> orderList = orderDao.findByCreationDate(creationDate);
        Assert.assertNotNull("Order Is Null", orderList);
        Assert.assertTrue("OrderDetail List Is null", orderList.get(0).getOrderDetailSet().size() >= 0);
    }

    @Test
    public void findByDeliveryAddress() throws Exception {
        String deliveryAddress = "Cra 42A # 80B - 101 AP 4B";
        List<Order> orderList = orderDao.findByDeliveryAddress(deliveryAddress);
        Assert.assertNotNull("Order Is Null", orderList);
        Assert.assertTrue("OrderDetail List Is null", orderList.get(0).getOrderDetailSet().size() >= 0);
    }

    @Test
    public void findByTotal() throws Exception {
        double total = 30000;
        List<Order> orderList = orderDao.findByTotal(total);
        Assert.assertNotNull("Order Is Null", orderList);
        Assert.assertTrue("OrderDetail List Is null", orderList.get(0).getOrderDetailSet().size() >= 0);
    }

    @Test
    public void save() throws Exception {
        String jsonOrder = "{\"orderId\":null,\"creationDate\":\"2019-07-07\"," +
                "\"deliveryAddress\":\"Cra 42A # 80B-101 Ap. 4B\",\"total\":30000," +
                "\"customerId\":26,\"orderDetailSet\":[{\"orderDetailId\":1," +
                "\"productDescription\":\"Producto 1 Prueba\",\"price\":30000," +
                "\"quantity\":1,\"productId\":21},{\"orderDetailId\":2," +
                "\"productDescription\":\"Producto 22 Prueba\",\"price\":30000," +
                "\"quantity\":1,\"productId\":22}]}";
        Customer customer = new Customer();
        customer.setCustomerId(26);
        customer.setName("Carlos A Maturana M");
        customer.setEmail("carlos.maturana@dytssol.com");

        Product product = new Product();
        product.setProductId(21);
        product.setName("Producto 1");
        product.setProductDescription("Producto 1 Prueba");
        product.setPrice(30000);

        Order order = new Order();
        order.setCreationDate(new Date());
        order.setDeliveryAddress("Cra 51 # 79-34 Of. 506");
        order.setTotal(30000);
        order.setCustomerId(customer);

        Set<OrderDetail> orderDetailSet = new HashSet<>();
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderId(order);
        orderDetail.setProductId(product);
        orderDetail.setProductDescription(product.getProductDescription());
        orderDetail.setQuantity(1);
        orderDetail.setPrice(product.getPrice());
        orderDetailSet.add(orderDetail);

        order.setOrderDetailSet(orderDetailSet);

        Object orderSaved = orderDao.save(order);
        Assert.assertNotNull("Order Is Null", orderSaved);
        Assert.assertNotEquals(order, orderSaved);
    }

}