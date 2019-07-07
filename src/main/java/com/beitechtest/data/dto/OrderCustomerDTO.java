/**
 * Development and Technologies Solutions S.A.S
 * beitechtest-backend
 * OrderCustomerDTO.java
 * <p>
 * Derechos de Autor 2015-2019 D&TS ©
 * Todos los Derechos Reservados.
 */
package com.beitechtest.data.dto;

import java.util.Date;

/**
 * @author: CarlosMatt
 * @version: 1.0.1
 * @created: 06/07/2019 10:26 AM
 */
public class OrderCustomerDTO {

    private Date creationDate;
    Integer orderId;
    double total;
    String deliveryAddress;
    String products;

    public OrderCustomerDTO() {
    }

    public OrderCustomerDTO(Date creationDate, Integer orderId, double total, String deliveryAddress, String products) {
        this.creationDate = creationDate;
        this.orderId = orderId;
        this.total = total;
        this.deliveryAddress = deliveryAddress;
        this.products = products;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getProducts() {
        return products;
    }

    public void setProducts(String products) {
        this.products = products;
    }
}
