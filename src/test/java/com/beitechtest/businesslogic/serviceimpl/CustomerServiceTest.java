package com.beitechtest.businesslogic.serviceimpl;

import com.beitechtest.app.BeitechtestcammApplication;
import com.beitechtest.data.dao.CustomerDao;
import com.beitechtest.data.dao.ProductDao;
import com.beitechtest.data.entity.Customer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BeitechtestcammApplication.class)
public class CustomerServiceTest {

    @Autowired
    CustomerService customerService;


    @Test
    public void findAll() throws Exception {
        List<Customer> customerList = customerService.findAll();
        assertNotNull("Customer Is null", customerList);
        assertTrue("Customer Is null", customerList.size() >= 0);
    }

    @Test
    public void findByCustomerId() throws Exception {
        Integer customerId = 26;
        Customer customerFound = customerService.findByCustomerId(customerId);
        assertTrue("Customer Not Found", customerFound.getCustomerId() == customerId);
    }

}