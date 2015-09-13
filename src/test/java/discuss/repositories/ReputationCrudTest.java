package discuss.repositories;

import discuss.conf.factories.ReputationFactory;
import discuss.domain.Reputation;
import discuss.respository.ReputationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Date;

/**
 * Created by student on 2015/06/03.Karl Otto 212026992
 */
public class ReputationCrudTest  extends AbstractTestNGSpringContextTests {
    private Long id;
    @Autowired
    private ReputationRepository repository;

    @Test
    public void create() throws Exception {
        Date date = new Date();
        Reputation role = ReputationFactory.create(date, 23);
        repository.save(role);
        id=role.getId();
        Assert.assertNotNull(role);
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        Reputation role = repository.findOne(id);
        Assert.assertNotNull(role);

    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        Reputation role = repository.findOne(id);
        Reputation newrole = new Reputation
                .Builder(role.getDate())
                .copy(role)
                .value(23)
                .build();
        // SAVE UPDATED ROLE
        repository.save(newrole);

        // GET THE SAVED ROLE
        Reputation savedRole = repository.findOne(id);
        Assert.assertEquals(savedRole.getValue(),"SYS ADMIN");
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        Reputation role = repository.findOne(id);
        repository.delete(role);
        Reputation deletedRole = repository.findOne(id);
        Assert.assertNull(deletedRole);

    }
}