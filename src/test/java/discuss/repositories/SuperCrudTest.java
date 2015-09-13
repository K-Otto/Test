package discuss.repositories;

import discuss.App;
import discuss.conf.factories.HiveFactory;
import discuss.conf.factories.SuperFactory;
import discuss.domain.Hive;
import discuss.domain.SubLocation;
import discuss.domain.Super;
import discuss.respository.HiveRepository;
import discuss.respository.SuperRepository;
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
public class SuperCrudTest extends AbstractTestNGSpringContextTests {
    private Long id;
    @Autowired
    private SuperRepository repository;

    @Test
    public void create() throws Exception {
        List<Hive> jobs = new ArrayList<Hive>();

        Super role = SuperFactory.create("date", jobs);
        repository.save(role);
        id=role.getId();
        Assert.assertNotNull(role);
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        Super role = repository.findOne(id);
        Assert.assertNotNull(role);

    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        List<Hive> jobs = new ArrayList<Hive>();
        Super role = repository.findOne(id);
        Super newrole = new Super
                .Builder(role.getSuperState())
                .copy(role)
                .hives(jobs)
                .build();
        // SAVE UPDATED ROLE
        repository.save(newrole);

        // GET THE SAVED ROLE
        Super savedRole = repository.findOne(id);
        Assert.assertEquals(savedRole.getHives(),jobs);
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        Super role = repository.findOne(id);
        repository.delete(role);
        Super deletedRole = repository.findOne(id);
        Assert.assertNull(deletedRole);

    }
}