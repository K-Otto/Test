package discuss.repositories;

import discuss.App;


import discuss.conf.factories.SubLocationFactory;
import discuss.domain.Location;
import discuss.domain.SubLocation;

import discuss.respository.SubLocationRepository;
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

public class SubLocationCrudTest extends AbstractTestNGSpringContextTests {
    private Long id;
    @Autowired
    private SubLocationRepository repository;

    @Test
    public void create() throws Exception {
        List<Location> jobs = new ArrayList<Location>();

        SubLocation role = SubLocationFactory.create("date", jobs);
        repository.save(role);
        id=role.getId();
        Assert.assertNotNull(role);
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        SubLocation role = repository.findOne(id);
        Assert.assertNotNull(role);

    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        List<Location> jobs = new ArrayList<Location>();
        SubLocation role = repository.findOne(id);
        SubLocation newrole = new SubLocation
                .Builder(role.getSubLocationName())
                .copy(role)
                .locations(jobs)
                .build();
        // SAVE UPDATED ROLE
        repository.save(newrole);

        // GET THE SAVED ROLE
        SubLocation savedRole = repository.findOne(id);
        Assert.assertEquals(savedRole.getLocation(),jobs);
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        SubLocation role = repository.findOne(id);
        repository.delete(role);
        SubLocation deletedRole = repository.findOne(id);
        Assert.assertNull(deletedRole);

    }
}
