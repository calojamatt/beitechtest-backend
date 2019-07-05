package com.beitechtest.data.dao;

import com.beitechtest.app.BeitechtestcammApplication;
import com.beitechtest.data.entity.Customer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BeitechtestcammApplication.class)
public class CustomerDaoTest {

    @Autowired
    CustomerDao customerDao;

    @Test
    public void findAll() throws Exception {
        List<Customer> customerList = customerDao.findAll();
        Assert.assertTrue(customerList.size() >= 0);
    }

    @Test
    public void findByCustomerId() throws Exception {
        Integer customerId = 26;
        Customer customer = customerDao.findByCustomerId(customerId);
        Assert.assertNotNull("Customer Is Null", customer);
        Assert.assertTrue("Customer Is Null", customer.getProductList().size() >= 0);
    }

    @Test
    public void findByName() throws Exception {
        String name = "Carlos A Maturana M";
        Customer customer = customerDao.findByName(name);
        Assert.assertNotNull("Customer Is Null", customer);
        Assert.assertTrue("Customer Is Null", customer.getProductList().size() >= 0);
    }

    @Test
    public void findByEmail() throws Exception {
        String email = "carlos.maturana@dytssol.com";
        Customer customer = customerDao.findByEmail(email);
        Assert.assertNotNull("Customer Is Null", customer);
        Assert.assertTrue("Customer Is Null", customer.getProductList().size() >= 0);
    }

}