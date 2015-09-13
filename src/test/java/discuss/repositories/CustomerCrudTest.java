package discuss.repositories;

import discuss.App;
import discuss.conf.factories.BucketFactory;
import discuss.conf.factories.CustomerFactory;
import discuss.domain.Bucket;
import discuss.domain.Customer;
import discuss.domain.Harvest;
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

    private Long id;
    @Autowired
    private CustomerRepository repository;

    @Test
    public void create() throws Exception {
        Customer role = CustomerFactory.create("ADMIN", "System Administrator", "");
        repository.save(role);
        id=role.getId();
        Assert.assertNotNull(role);
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        Customer role = repository.findOne(id);
        Assert.assertNotNull(role);

    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        Customer role = repository.findOne(id);
        Customer newrole = new Customer
                .Builder(role.getFirstName())
                .copy(role)
                .email("SYS ADMIN")
                .build();
        // SAVE UPDATED ROLE
        repository.save(newrole);

        // GET THE SAVED ROLE
        Customer savedRole = repository.findOne(id);
        Assert.assertEquals(savedRole.getEmail(),"SYS ADMIN");
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        Customer role = repository.findOne(id);
        repository.delete(role);
        Customer deletedRole = repository.findOne(id);
        Assert.assertNull(deletedRole);

    }
}
