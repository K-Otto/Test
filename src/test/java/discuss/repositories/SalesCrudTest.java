package discuss.repositories;

import discuss.App;
import discuss.conf.factories.SalesFactory;
import discuss.domain.Bucket;
import discuss.domain.Customer;
import discuss.domain.Sales;
import discuss.respository.SalesRepository;
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
public class SalesCrudTest extends AbstractTestNGSpringContextTests {
    private Long id;
    @Autowired
    private SalesRepository repository;

    @Test
    public void create() throws Exception {
        List<Customer> jobs = new ArrayList<Customer>();
        List<Bucket> buc = new ArrayList<Bucket>();
        Sales role = SalesFactory.create("date", 23.00,buc, jobs);
        repository.save(role);
        id=role.getId();
        Assert.assertNotNull(role);
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        Sales role = repository.findOne(id);
        Assert.assertNotNull(role);

    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        Sales role = repository.findOne(id);
        Sales newrole = new Sales
                .Builder(role.getSalesDate())
                .copy(role)
                .price(22.00)
                .build();
        // SAVE UPDATED ROLE
        repository.save(newrole);

        // GET THE SAVED ROLE
        Sales savedRole = repository.findOne(id);
        Assert.assertEquals(savedRole.getPrice(),22.00);
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        Sales role = repository.findOne(id);
        repository.delete(role);
        Sales deletedRole = repository.findOne(id);
        Assert.assertNull(deletedRole);

    }
}
