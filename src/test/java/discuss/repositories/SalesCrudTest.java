package discuss.repositories;

import discuss.App;
import discuss.conf.factories.*;
import discuss.domain.*;
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
        Beekeeper beekeepers = BeekeeperFactory.create("karl", "otto", "karl1256@yahoo.com");
        Location locations = LocationFactory.create("Darling", beekeepers);
        SubLocation subLocations = SubLocationFactory.create("Fossil", locations);
        Harvest harvests = HarvestFactory.create("Fossil", 66.00, subLocations);
        Customer customers = CustomerFactory.create("","","");
        Bucket buckets = BucketFactory.create( 66.00, harvests);
        Sales role = SalesFactory.create("date", 22.00,buckets, customers);
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
                .build();
        // SAVE UPDATED ROLE
        repository.save(newrole);

        // GET THE SAVED ROLE

        Assert.assertEquals(newrole.getPrice(),22.00);
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        Sales role = repository.findOne(id);
        repository.delete(role);
        Sales deletedRole = repository.findOne(id);
        Assert.assertNull(deletedRole);

    }
}
