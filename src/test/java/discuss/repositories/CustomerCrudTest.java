package discuss.repositories;

import discuss.App;
import discuss.conf.factories.BucketFactory;
import discuss.conf.factories.CustomerFactory;
import discuss.conf.factories.SalesFactory;
import discuss.domain.Bucket;
import discuss.domain.Customer;
import discuss.domain.Harvest;
import discuss.domain.Sales;
import discuss.respository.BucketRepository;
import discuss.respository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;




import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/09/13.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration

public class CustomerCrudTest extends AbstractTestNGSpringContextTests{

    private long id;
    @Autowired
    private CustomerRepository repository;

    @Test
    public void create() throws Exception {

        Customer customers = CustomerFactory.create("karl", "otto", "karl1256@yahoo.com");

        repository.save(customers);
        id=customers.getId();
        Assert.assertNotNull(customers.getId());
        System.out.println(customers.getId());
    }


    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        Customer role = repository.findOne(id);

        Assert.assertEquals("karl",role.getFirstName());

    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        Customer role = repository.findOne(id);
        Customer newrole = new Customer
                .Builder(role.getFirstName())
                .copy(role)
                .email("karl1256@gmail.com")
                .build();
        // SAVE UPDATED ROLE
        repository.save(newrole);

        // GET THE SAVED ROLE
        Customer savedRole = repository.findOne(id);
        Assert.assertEquals(savedRole.getEmail(),"karl1256@gmail.com");
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        Customer role = repository.findOne(id);
        repository.delete(role);
        Customer deletedRole = repository.findOne(id);
        Assert.assertNull(deletedRole);

    }
}
