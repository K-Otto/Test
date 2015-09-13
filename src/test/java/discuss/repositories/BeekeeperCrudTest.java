package discuss.repositories;

import discuss.App;
import discuss.conf.factories.BeekeeperFactory;
import discuss.domain.Beekeeper;
import discuss.respository.BeekeeperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;




import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by student on 2015/09/13.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class BeekeeperCrudTest extends AbstractTestNGSpringContextTests{

    private Long id;
    @Autowired
    private BeekeeperRepository repository;

    @Test
    public void create() throws Exception {
        Beekeeper role = BeekeeperFactory.create("ADMIN", "System Administrator","");
        repository.save(role);
        id=role.getId();
        Assert.assertNotNull(role);
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        Beekeeper role = repository.findOne(id);
        Assert.assertNotNull(role);

    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        Beekeeper role = repository.findOne(id);
        Beekeeper newrole = new Beekeeper
                .Builder(role.getFirstName())
                .copy(role)
                .email("SYS ADMIN")
                .build();
        // SAVE UPDATED ROLE
        repository.save(newrole);

        // GET THE SAVED ROLE
        Beekeeper savedRole = repository.findOne(id);
        Assert.assertEquals(savedRole.getEmail(),"SYS ADMIN");
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        Beekeeper role = repository.findOne(id);
        repository.delete(role);
        Beekeeper deletedRole = repository.findOne(id);
        Assert.assertNull(deletedRole);

    }
}
