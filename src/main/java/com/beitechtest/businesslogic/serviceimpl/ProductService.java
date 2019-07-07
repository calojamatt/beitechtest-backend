/**
 * Development and Technologies Solutions S.A.S
 * beitechtest-backend
 * ProductService.java
 * <p>
 * Derechos de Autor 2015-2019 D&TS ©
 * Todos los Derechos Reservados.
 */
package com.beitechtest.businesslogic.serviceimpl;

import com.beitechtest.businesslogic.service.IProductService;
import com.beitechtest.data.dao.ProductDao;
import com.beitechtest.data.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: CarlosMatt
 * @version: 1.0.1
 * @created: 04/07/2019 3:46 PM
 */
@Service
public class ProductService implements IProductService {

    @Autowired
    ProductDao productDao;

    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }

    @Override
    public Product findByProductId(Integer productId) {
        return productDao.findByProductId(productId);
    }
}
