/**
 * Development and Technologies Solutions S.A.S
 * beitechtest-backend
 * OrderDeserializer.java
 * <p>
 * Derechos de Autor 2015-2019 D&TS ©
 * Todos los Derechos Reservados.
 */
package com.beitechtest.businesslogic.converters;

import com.beitechtest.data.entity.Customer;
import com.beitechtest.data.entity.Order;
import com.beitechtest.data.entity.OrderDetail;
import com.beitechtest.data.entity.Product;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: CarlosMatt
 * @version: 1.0.1
 * @created: 08/07/2019 12:21 AM
 */
public class OrderDeserializer extends StdDeserializer<Order> {

    public OrderDeserializer() {
        this(null);
    }

    protected OrderDeserializer(Class<?> vc) {
        super(vc);
    }


    /**
     * This implements a custom deserializer for Order, because a error
     * generated with JsonMapping Infinite recursion, caused for relations defined in entity classes.
     *
     * Return an <pre>@code Order</pre> object
     *
     * @param jsonParser <pre>@code JsonParser</pre>
     * @param deserializationContext <pre>@code DeserializationContext</pre>
     *
     *
     * @return <code>Order</code>
     * @throws java.io.IOException, com.fasterxml.jackson.core.JsonProcessingException
     */
    @Override
    public Order deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException, JsonProcessingException {
        Order order = new Order();
        Customer customer = new Customer();
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        try {
            order.setCreationDate(new SimpleDateFormat("yyyy-MM-dd").parse(node.get("creationDate").asText()));
            order.setDeliveryAddress(node.get("deliveryAddress").asText());
            order.setTotal(node.get("total").asDouble());
            customer.setCustomerId(node.get("customerId").intValue());
            order.setCustomerId(customer);
            ArrayNode orderDetailSetNode = (ArrayNode) node.get("orderDetailSet");
            Set<OrderDetail> orderDetailSet = new HashSet<>();
            for (JsonNode orderDetailNode : orderDetailSetNode) {
                OrderDetail orderDetail = new OrderDetail();
                orderDetail.setOrderDetailId(orderDetailNode.get("orderDetailId").intValue());
                orderDetail.setProductDescription(orderDetailNode.get("productDescription").asText());
                orderDetail.setPrice(orderDetailNode.get("price").asDouble());
                orderDetail.setQuantity(orderDetailNode.get("quantity").intValue());
                Product product = new Product();
                product.setProductId(orderDetailNode.get("productId").intValue());
                orderDetail.setProductId(product);
                orderDetailSet.add(orderDetail);
            }
            order.setOrderDetailSet(orderDetailSet);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return order;
    }
}
