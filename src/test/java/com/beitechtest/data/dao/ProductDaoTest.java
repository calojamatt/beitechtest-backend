package com.beitechtest.data.dao;

import com.beitechtest.app.BeitechtestcammApplication;
import com.beitechtest.data.entity.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BeitechtestcammApplication.class)
public class ProductDaoTest {

    @Autowired
    ProductDao productDao;

    @Test
    public void findAll() throws Exception {
        List<Product> productList = productDao.findAll();
        Assert.assertTrue(productList.size() >= 0);
    }

    //@Test
    public void findByCustomerId() throws Exception {
        int customerId = 26;
        List<Product> productList = productDao.findByCustomerId(customerId);
        Assert.assertTrue(productList.size() >= 0);
    }

    @Test
    public void findByProductId() throws Exception {
        int productId = 21;
        Product product = productDao.findByProductId(productId);
        Assert.assertNotNull("Producto Is Null", product);
        Assert.assertTrue(product.getCustomerList().size() >= 0);
    }

    @Test
    public void findByName() throws Exception {
        String name = "Producto 1";
        Product product = productDao.findByName(name);
        Assert.assertNotNull("Producto Is Null", product);
    }

    @Test
    public void findByProductDescription() throws Exception {
        String productDescription = "Prueba de producto 1";
        Product product = productDao.findByProductDescription(productDescription);
        Assert.assertNotNull("Product Is Null", product);
    }

    @Test
    public void findByPrice() throws Exception {
        double price = 30000;
        Product product = productDao.findByPrice(price);
        Assert.assertNotNull("Product Is Null", product);
    }

}