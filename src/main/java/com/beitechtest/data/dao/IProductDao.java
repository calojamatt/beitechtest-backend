/**
 * Development and Technologies Solutions S.A.S
 * beitechtest-backend
 * IProductDao.java
 * <p>
 * Derechos de Autor 2015-2019 D&TS ©
 * Todos los Derechos Reservados.
 */

package com.beitechtest.data.dao;

import com.beitechtest.data.entities.Product;

import java.util.List;

/**
 * @author: CarlosMatt
 * @version: 1.0.1
 * @created: 04/07/2019 3:24 PM
 */
public interface IProductDao {
    List<Product> findAll();
    List<Product> findByCustomerId(Integer customerId);
    Product findByProductId(Integer productId);
    Product findByName(String name);
    Product findByProductDescription(String productDescription);
    Product findByPrice(double price);
}
