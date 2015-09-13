package discuss.repositories;

import discuss.conf.factories.UserFactory;
import discuss.domain.Reputation;
import discuss.domain.User;
import discuss.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/06/03.Karl Otto 212026992
 */
public class UserCrudTest extends AbstractTestNGSpringContextTests {
    private Long id;
    @Autowired
    private UserRepository repository;

    @Test
    public void create() throws Exception {
        List<Reputation> jobs = new ArrayList<Reputation>();

        User role = UserFactory.create("date", "23","uj","jj",jobs);
        repository.save(role);
        id=role.getId();
        Assert.assertNotNull(role);
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        User role = repository.findOne(id);
        Assert.assertNotNull(role);

    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        User role = repository.findOne(id);
        User newrole = new User
                .Builder(role.getEmail())
                .copy(role)
                .status("23")
                .build();
        // SAVE UPDATED ROLE
        repository.save(newrole);

        // GET THE SAVED ROLE
        User savedRole = repository.findOne(id);
        Assert.assertEquals(savedRole.getStatus(),"SYS ADMIN");
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        User role = repository.findOne(id);
        repository.delete(role);
        User deletedRole = repository.findOne(id);
        Assert.assertNull(deletedRole);

    }
}
