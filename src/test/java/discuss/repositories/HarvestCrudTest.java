package discuss.repositories;

import discuss.App;
import discuss.conf.factories.*;
import discuss.domain.*;
import discuss.respository.HarvestRepository;
import discuss.respository.HiveRepository;
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
public class HarvestCrudTest extends AbstractTestNGSpringContextTests {
    private Long id;
    @Autowired
    private HarvestRepository repository;

    @Test
    public void create() throws Exception {
        Beekeeper beekeepers = BeekeeperFactory.create("karl", "otto", "karl1256@yahoo.com");
        Location locations = LocationFactory.create("Darling", beekeepers);
        SubLocation subLocations = SubLocationFactory.create("Fossil", locations);

        Harvest role = HarvestFactory.create("date", 22.00, subLocations);
        repository.save(role);
        id=role.getId();
        Assert.assertNotNull(role);
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        Harvest role = repository.findOne(id);
        Assert.assertNotNull(role);

    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {

        Harvest role = repository.findOne(id);
        Harvest newrole = new Harvest
                .Builder(role.getHarvestDate())
                .copy(role)

                .build();
        // SAVE UPDATED ROLE
        repository.save(newrole);

        // GET THE SAVED ROLE
        Harvest savedRole = repository.findOne(id);
        Assert.assertEquals(savedRole.getHarvestDate(),"date");
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        Harvest role = repository.findOne(id);
        repository.delete(role);
        Harvest deletedRole = repository.findOne(id);
        Assert.assertNull(deletedRole);

    }
}