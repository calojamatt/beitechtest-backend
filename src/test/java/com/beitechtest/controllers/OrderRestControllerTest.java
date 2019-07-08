package com.beitechtest.controllers;

import com.beitechtest.app.BeitechtestcammApplication;
import com.beitechtest.businesslogic.serviceimpl.OrderService;
import com.beitechtest.data.dto.OrderCustomerDTO;
import com.beitechtest.data.entity.Customer;
import com.beitechtest.data.entity.Order;
import com.beitechtest.data.entity.OrderDetail;
import com.beitechtest.data.entity.Product;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BeitechtestcammApplication.class)
@AutoConfigureMockMvc
public class OrderRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrderService orderService;

    private Customer customer;
    private Order order;

    @Before
    public void setUp() {
        customer = new Customer();
        customer.setCustomerId(26);
        customer.setName("Carlos A Maturana M");
        customer.setEmail("carlos.maturana@dytssol.com");

        order = new Order();
        order.setOrderId(83);
        order.setCreationDate(new Date());
        order.setDeliveryAddress("Cra 51 # 79-34 Of. 506");
        order.setTotal(30000);
        order.setCustomerId(customer);
    }

    //@Test
    public void listOrdersByCustomerAndDate() throws Exception {

        OrderCustomerDTO orderCustomerDTO = new OrderCustomerDTO();
        orderCustomerDTO.setOrderId(83);
        orderCustomerDTO.setCreationDate(new Date());
        orderCustomerDTO.setDeliveryAddress("Cra 51 # 79-34 Of. 506");
        orderCustomerDTO.setTotal(30000);

        Integer customerId = 26;
        LocalDate localDateStart = LocalDate.of(2019, 7,1);
        LocalDate localDateEnd = LocalDate.of(2019, 7,31);
        Date startDate = java.util.Date.from(localDateStart.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        Date endDate = java.util.Date.from(localDateEnd.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());

        List<OrderCustomerDTO> allOrders = Arrays.asList(orderCustomerDTO);

        given(orderService.findOrderByCustomerAndDate(customerId, startDate, endDate)).willReturn(allOrders);

        String urlTemplate = String.format("/beitechtest/order/listCustomerOrder/%s/%s/%s",
                customerId.toString(), localDateStart.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                localDateEnd.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));

        mockMvc.perform(get(urlTemplate)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].orderId", is(orderCustomerDTO.getOrderId())));
    }

    //@Test
    public void listAllOrders() throws Exception {
        List<Order> allOrders = Arrays.asList(order);

        given(orderService.findAll()).willReturn(allOrders);

        mockMvc.perform(get("/beitechtest/order/listAllOrders")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].orderId", is(order.getOrderId())));
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

        Order orderSave = new Order();
        orderSave.setCreationDate(new Date());
        orderSave.setDeliveryAddress("Cra 42A # 80B-101 Ap. 4B");
        orderSave.setTotal(30000);
        orderSave.setCustomerId(customer);

        List<OrderDetail> orderDetailList = new ArrayList<>();
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderId(orderSave);
        orderDetail.setProductId(product);
        orderDetail.setProductDescription(product.getProductDescription());
        orderDetail.setQuantity(1);
        orderDetail.setPrice(product.getPrice());
        orderDetailList.add(orderDetail);

        orderSave.setOrderDetailList(orderDetailList);

        String contentJson = new ObjectMapper().writeValueAsString(orderSave);

        mockMvc.perform(post("/beitechtest/order/saveOrder")
                .content(contentJson)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
                //.andExpect(jsonPath("$").isNotEmpty());
    }

}