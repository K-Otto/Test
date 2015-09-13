package discuss.repositories;

import discuss.App;
import discuss.conf.factories.RoleFactory;
import discuss.domain.Role;
import discuss.respository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by [Karl Otto 212026992] on 2015/06/03.
 *
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class RoleCrudTest extends AbstractTestNGSpringContextTests {
    private Long id;
    @Autowired
    private RoleRepository repository;

    @Test
    public void create() throws Exception {
        Role role = RoleFactory.create("ADMIN", "System Administrator");
        repository.save(role);
        id=role.getId();
        Assert.assertNotNull(role);
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        Role role = repository.findOne(id);
        Assert.assertNotNull(role);

    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        Role role = repository.findOne(id);
        Role newrole = new Role
                .Builder(role.getName())
                .copy(role)
                .description("SYS ADMIN")
                .build();
        // SAVE UPDATED ROLE
        repository.save(newrole);

        // GET THE SAVED ROLE
        Role savedRole = repository.findOne(id);
        Assert.assertEquals(savedRole.getDescription(),"SYS ADMIN");
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        Role role = repository.findOne(id);
        repository.delete(role);
        Role deletedRole = repository.findOne(id);
        Assert.assertNull(deletedRole);

    }
}
