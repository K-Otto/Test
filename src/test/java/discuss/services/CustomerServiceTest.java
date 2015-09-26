package discuss.services;

import discuss.App;
import discuss.Services.CustomerService;
import discuss.conf.factories.CustomerFactory;
import discuss.domain.Customer;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;
/**
 * Created by student on 2015/09/26.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class CustomerServiceTest  extends AbstractTestNGSpringContextTests {

    private Long id;
    private Customer customerGlobal;

    @Autowired
    private CustomerService service;

    @Test
    public void create() throws Exception {
        Customer customers = CustomerFactory
                .create("Piet", "pieter", "Karl@gmail.com");

        service.saveCustomer(customers.getFirstName(),
                customers.getLastName(),
                customers.getEmail());


        id = customers.getId();
       customerGlobal = customers;
        Assert.assertNotNull(customers);
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        // Get subject
     //   String idtest = id + "";
     //   Long longId = Long.parseLong(idtest);
     //   Customer beekeepers = service.getCustomer(longId);
      //  customerGlobal = service.getCustomer(longId);
     //   Assert.assertNotNull(customerGlobal);
    }

}

