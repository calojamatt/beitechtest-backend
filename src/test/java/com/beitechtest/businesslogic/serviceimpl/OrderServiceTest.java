package com.beitechtest.businesslogic.serviceimpl;

import com.beitechtest.app.BeitechtestcammApplication;
import com.beitechtest.data.dto.OrderCustomerDTO;
import com.beitechtest.data.entity.Customer;
import com.beitechtest.data.entity.Order;
import com.beitechtest.data.entity.OrderDetail;
import com.beitechtest.data.entity.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BeitechtestcammApplication.class)
public class OrderServiceTest {

    @Autowired
    OrderService orderService;

    @Test
    public void findAll() throws Exception {
        List<Order> orderList = orderService.findAll();
        assertTrue("OrderList is empty", orderList.size() > 0);
    }

    @Test
    public void findByOrderId() throws Exception {
        Integer orderId = 83;
        Order orderFound = orderService.findByOrderId(orderId);
        assertNotNull("Order is null", orderFound);
        assertEquals(orderFound.getOrderId(),orderId);
    }

    @Test
    public void findCustomerOrderByDate() throws Exception {
        Integer customerId = 26;
        LocalDate localDateStart = LocalDate.of(2019, 7,1);
        LocalDate localDateEnd = LocalDate.of(2019, 7,31);
        Date dateStart = java.util.Date.from(localDateStart.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        Date dateEnd = java.util.Date.from(localDateEnd.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        List<OrderCustomerDTO> orderListFound = orderService.findOrderByCustomerAndDate(customerId, dateStart, dateEnd);
        assertTrue("OrderDetail List Is null", orderListFound.size() >= 0);
    }

    @Test
    public void saveOrder() throws Exception {
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

        List<OrderDetail> orderDetailList = new ArrayList<>();
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderId(order);
        orderDetail.setProductId(product);
        orderDetail.setProductDescription(product.getProductDescription());
        orderDetail.setQuantity(1);
        orderDetail.setPrice(product.getPrice());
        orderDetailList.add(orderDetail);

        order.setOrderDetailList(orderDetailList);

        Integer orderId = orderService.saveOrder(order);
        assertTrue("Order Is Null", orderId > 0);
    }

}