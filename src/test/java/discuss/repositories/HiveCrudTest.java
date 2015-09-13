package discuss.repositories;

import discuss.App;
import discuss.conf.factories.HiveFactory;
import discuss.domain.Hive;
import discuss.domain.SubLocation;
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
public class HiveCrudTest extends AbstractTestNGSpringContextTests {
    private Long id;
    @Autowired
    private HiveRepository repository;

    @Test
    public void create() throws Exception {
        List<SubLocation> jobs = new ArrayList<SubLocation>();

        Hive role = HiveFactory.create("date", jobs);
        repository.save(role);
        id=role.getId();
        Assert.assertNotNull(role);
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        Hive role = repository.findOne(id);
        Assert.assertNotNull(role);

    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        List<SubLocation> jobs = new ArrayList<SubLocation>();
        Hive role = repository.findOne(id);
        Hive newrole = new Hive
                .Builder(role.getHiveState())
                .copy(role)
                .subLocations(jobs)
                .build();
        // SAVE UPDATED ROLE
        repository.save(newrole);

        // GET THE SAVED ROLE
        Hive savedRole = repository.findOne(id);
        Assert.assertEquals(savedRole.getSubLocation(),jobs);
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        Hive role = repository.findOne(id);
        repository.delete(role);
        Hive deletedRole = repository.findOne(id);
        Assert.assertNull(deletedRole);

    }
}