/**
 * beitechtest-backend
 * IProductService.java
 * <p>
 * Derechos de Autor 2015-2019 D&TS ©
 * Todos los Derechos Reservados.
 */

package com.beitechtest.businesslogic.service;

import com.beitechtest.data.entity.Product;

import java.util.List;

/**
 * @author: CarlosMatt
 * @version: 1.0.1
 * @created: 04/07/2019 3:38 PM
 */
public interface IProductService {
    List<Product> findAll();
    List<Product> findByCustomerId(Integer customerId);
}
