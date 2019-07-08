package com.beitechtest.businesslogic.serviceimpl;

import com.beitechtest.app.BeitechtestcammApplication;
import com.beitechtest.businesslogic.converters.OrderDeserializer;
import com.beitechtest.data.dto.OrderCustomerDTO;
import com.beitechtest.data.entity.Customer;
import com.beitechtest.data.entity.Order;
import com.beitechtest.data.entity.OrderDetail;
import com.beitechtest.data.entity.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BeitechtestcammApplication.class)
public class OrderServiceTest {

    @Autowired
    OrderService orderService;

    @Test
    public void findAll() throws Exception {
        List<Order> orderList = orderService.findAll();
        System.out.println(orderList);
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
        String orderJson = "{\"orderId\":null,\"creationDate\":\"2019-07-07\"," +
                "\"deliveryAddress\":\"Cra 42A # 80B-101 Ap. 4B\",\"total\":30000," +
                "\"customerId\":26,\"orderDetailSet\":[{\"orderDetailId\":1," +
                "\"productDescription\":\"Producto 1 Prueba\",\"price\":30000," +
                "\"quantity\":1,\"productId\":21},{\"orderDetailId\":2," +
                "\"productDescription\":\"Producto 22 Prueba\",\"price\":30000," +
                "\"quantity\":1,\"productId\":22}]}";

        Integer orderId = orderService.saveOrder(orderJson);
        assertTrue("Order Is Null", orderId > 0);
    }

}