/**
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

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author: CarlosMatt
 * @version: 1.0.1
 * @created: 04/07/2019 3:46 PM
 */
@Transactional
@Service
public class ProductService implements IProductService {

    @Autowired
    private ProductDao productDao;

    /**
     * Returns a list of All Products
     *
     * @return <code>List<Product></code>
     */
    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }

    /**
     * Return a Product
     *
     * @param productId <pre>@code Integer</pre>
     *
     * @return <code>Product</code>
     */
    @Override
    public Product findByProductId(Integer productId) {
        return productDao.findByProductId(productId);
    }
}
