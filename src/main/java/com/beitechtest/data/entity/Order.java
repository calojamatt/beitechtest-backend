/**
 * Order.java
 * 
 * Derechos de Autor 2019 D&TS © 
 * Todos los Derechos Reservados.
 */

package com.beitechtest.data.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Carlos Maturana <carlos.maturana@dytssl.com>
 * @version 1.0
 * @created 4/07/2019 09:50:16 AM
 */
@Entity
@Table(name = "\"order\"")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Order.findAll", query = "SELECT o FROM Order o"),
    @NamedQuery(name = "Order.findByOrderId", query = "SELECT o FROM Order o WHERE o.orderId = :orderId"),
    @NamedQuery(name = "Order.findByCreationDate", query = "SELECT o FROM Order o WHERE o.creationDate = :creationDate"),
    @NamedQuery(name = "Order.findByDeliveryAddress", query = "SELECT o FROM Order o WHERE o.deliveryAddress = :deliveryAddress"),
    @NamedQuery(name = "Order.findByTotal", query = "SELECT o FROM Order o WHERE o.total = :total"),
    @NamedQuery(name = "Order.findCustomerOrderByDate", query = "SELECT o FROM Order o "
            + "WHERE o.customerId.customerId = :customerId and o.creationDate between :startDate and :endDate")})
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "order_id")
    private Integer orderId;
    @Basic(optional = false)
    @Column(name = "creation_date")
    @Temporal(TemporalType.DATE)
    private Date creationDate;
    @Basic(optional = false)
    @Column(name = "delivery_address")
    private String deliveryAddress;
    @Basic(optional = false)
    @Column(name = "total")
    private double total;

    @JsonManagedReference(value = "order")
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "orderId")
    private List<OrderDetail> orderDetailList;

    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    @ManyToOne(optional = false)
    @JsonBackReference(value = "customer")
    private Customer customerId;

    public Order() {
    }

    public Order(Integer orderId) {
        this.orderId = orderId;
    }

    public Order(Integer orderId, Date creationDate, String deliveryAddress, double total) {
        this.orderId = orderId;
        this.creationDate = creationDate;
        this.deliveryAddress = deliveryAddress;
        this.total = total;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @XmlTransient
    public List<OrderDetail> getOrderDetailList() {
        return orderDetailList;
    }

    public void setOrderDetailList(List<OrderDetail> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderId != null ? orderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Order)) {
            return false;
        }
        Order other = (Order) object;
        return (this.orderId != null || other.orderId == null) && (this.orderId == null || this.orderId.equals(other.orderId));
    }

    @Override
    public String toString() {
        return "com.beitechtest.data.entity.Order[ orderId=" + orderId + " ]";
    }

}