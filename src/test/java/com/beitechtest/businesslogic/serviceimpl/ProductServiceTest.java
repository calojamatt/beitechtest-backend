package com.beitechtest.businesslogic.serviceimpl;

import com.beitechtest.app.BeitechtestcammApplication;
import com.beitechtest.data.entity.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BeitechtestcammApplication.class)
public class ProductServiceTest {

    @Autowired
    ProductService productService;

    @Test
    public void findAll() throws Exception {
        List<Product> productList = productService.findAll();
        assertNotNull("Product List is null", productList);
        assertTrue("Product List is null", productList.size() >= 0);
    }

    @Test
    public void findByProductId() throws Exception {
        Integer productId = 21;
        Product product = productService.findByProductId(productId);
        assertNotNull("Product List is null", product);
        assertTrue("Product List is null", product.getCustomerSet().size() >= 0);
    }

}