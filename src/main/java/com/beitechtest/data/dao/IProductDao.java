/**
 * Development and Technologies Solutions S.A.S
 * beitechtest-backend
 * IProductDao.java
 * <p>
 * Derechos de Autor 2015-2019 D&TS ©
 * Todos los Derechos Reservados.
 */

package com.beitechtest.data.dao;

import com.beitechtest.data.entity.Product;

import java.util.List;

/**
 * @author: CarlosMatt
 * @version: 1.0.1
 * @created: 04/07/2019 3:24 PM
 */
public interface IProductDao {
    List<Product> findAll();
    Product findByProductId(Integer productId);
    List<Product> findByName(String name);
    List<Product> findByProductDescription(String productDescription);
    List<Product> findByPrice(double price);
}
