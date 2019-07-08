/**
 * Development and Technologies Solutions S.A.S
 * beitechtest-backend
 * OrderService.java
 * <p>
 * Derechos de Autor 2015-2019 D&TS ©
 * Todos los Derechos Reservados.
 */
package com.beitechtest.businesslogic.serviceimpl;

import com.beitechtest.businesslogic.converters.OrderDeserializer;
import com.beitechtest.businesslogic.service.IOrderService;
import com.beitechtest.data.dao.CustomerDao;
import com.beitechtest.data.dao.OrderDao;
import com.beitechtest.data.dao.OrderDetailDao;
import com.beitechtest.data.dto.OrderCustomerDTO;
import com.beitechtest.data.entity.Customer;
import com.beitechtest.data.entity.Order;
import com.beitechtest.data.entity.OrderDetail;
import com.beitechtest.data.entity.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
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
    private OrderDao orderDao;
    @Autowired
    private OrderDetailDao orderDetailDao;
    @Autowired
    private CustomerDao customerDao;

    /**
     * Returns a list of All Order
     *
     * @return <code>List<Order></code>
     */
    @Override
    public List<Order> findAll() {
        return orderDao.findAll();
    }

    /**
     * Return an Order
     *
     * @param orderId <pre>@code Integer</pre>
     *
     * @return <code>Order</code>
     */
    @Override
    public Order findByOrderId(Integer orderId) {
        return orderDao.findByOrderId(orderId);
    }

    /**
     * Returns a list of data from Order
     *
     * @param customerId <pre>@code Integer</pre>
     * @param startDate <pre>@code Date</pre> startDate must be minor then endDate
     * @param endDate <pre>@code Date</pre> endDate must be greater then startDate
     *
     * @return <code>List<OrderCustomerDTO></code>
     */
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
            order.getOrderDetailSet().forEach(od -> {
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

    /**
     * Returns orderId if data is saved successfully.
     * Returns -1 if quantity of product in the list in OrderDetail is greater than 5
     * or if is there any product that do not belongs to customer in the Order
     * Return 0 if the list in OrderDetal is null or empty
     *
     * @param orderJson <pre>@code String</pre> data must be in Json format
     *
     * @return <code>Integer</code>
     * @throws java.io.IOException
     */
    @Override
    public Integer saveOrder(String orderJson) throws IOException {
        Integer orderId = 0;
        Order order = convertJsonToOrder(orderJson);

        if (order.getOrderDetailSet().size() > 0 && order.getOrderDetailSet().size() <= 5) {
            int totalProducts = order.getOrderDetailSet().size();
            int validTotalProducts = 0;
            Customer customer = customerDao.findByCustomerId(order.getCustomerId().getCustomerId());
            Set<Product> productSet = customer.getProductSet();
            validTotalProducts = order.getOrderDetailSet().stream()
                    .mapToInt(od -> (int) productSet.stream()
                            .filter(product -> product.getProductId() == od.getProductId().getProductId())
                            .count()).sum();
            orderId = (totalProducts == validTotalProducts ? orderDao.save(order) : -1);
            if (orderId > 0) {
                order.setOrderId(orderId);
                for(OrderDetail orderDetail : order.getOrderDetailSet()) {
                    orderDetail.setOrderId(order);
                    orderDetailDao.saveOrderDetail(orderDetail);
                }
            }
        } else if (order.getOrderDetailSet().size() > 5) {
            orderId = -1;
        }
        return orderId;
    }

    /**
     * Return an <pre>@code Order</pre> object
     *
     * @param orderJson <pre>@code JsonParser</pre> must be in Json format
     *
     * @return <code>Order</code>
     * @throws java.io.IOException
     */
    private Order convertJsonToOrder(String orderJson) throws IOException {
        Order order = null;
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addDeserializer(Order.class, new OrderDeserializer());
        objectMapper.registerModule(simpleModule);

        try {
            order = objectMapper.readValue(orderJson, Order.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return order;
    }

}
