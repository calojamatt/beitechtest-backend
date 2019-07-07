package com.beitechtest.controllers;

import com.beitechtest.app.BeitechtestcammApplication;
import com.beitechtest.businesslogic.serviceimpl.CustomerService;
import com.beitechtest.data.entity.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BeitechtestcammApplication.class)
@AutoConfigureMockMvc
//@TestPropertySource(locations = "classpath:application-dev.properties")
public class CustomerRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerService customerService;

    @Test
    public void listAllCustomer() throws Exception {
        Customer customer = new Customer();
        customer.setCustomerId(26);
        customer.setName("Carlos A Maturana M");
        customer.setEmail("carlos.maturana@dytssol.com");

        List<Customer> allCustomer = Arrays.asList(customer);

        given(customerService.findAll()).willReturn(allCustomer);

        mockMvc.perform(get("/beitechtest/customer/listAllCustomer")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", is(customer.getName())));
    }

}