package discuss.repositories;
import discuss.App;

import discuss.conf.factories.BeekeeperFactory;
import discuss.conf.factories.LocationFactory;
import discuss.domain.Beekeeper;
import discuss.domain.Location;
import discuss.respository.LocationRepository;
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

public class LocationCrudTest extends AbstractTestNGSpringContextTests {
    private Long id;
    @Autowired
    private LocationRepository repository;

    @Test
    public void create() throws Exception {
        Beekeeper beekeepers = BeekeeperFactory.create("karl", "otto", "karl1256@yahoo.com");

        Location locations = LocationFactory.create("Darling", beekeepers);
        repository.save(locations);
        id=locations.getId();
        Assert.assertNotNull(locations);


        System.out.println(locations.getId());
    }


    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        Location role = repository.findOne(id);

        Assert.assertEquals("Darling",role.getLocationName‭‭());

    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        Location role = repository.findOne(id);
        Location newrole = new Location
                .Builder‭("Langebaan")
                .ID(role.getId())
                .beekeepers(role.getBeekeepers())
                .build();
        // SAVE UPDATED ROLE
        repository.save(newrole);

        // GET THE SAVED ROLE

        Assert.assertEquals(newrole.getLocationName‭‭(),"Langebaan");
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        Location role = repository.findOne(id);
        repository.delete(role);
        Location deletedRole = repository.findOne(id);
        Assert.assertNull(deletedRole);

    }
}
