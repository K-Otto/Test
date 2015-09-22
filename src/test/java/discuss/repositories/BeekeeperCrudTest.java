package discuss.repositories;

import discuss.App;
import discuss.conf.factories.BeekeeperFactory;
import discuss.conf.factories.LocationFactory;
import discuss.domain.Beekeeper;
import discuss.domain.Location;
import discuss.respository.BeekeeperRepository;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;
import org.testng.Assert;


/**
 * Created by student on 2015/09/13.
 */

@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class BeekeeperCrudTest extends AbstractTestNGSpringContextTests{
    private long id;
    @Autowired
    private BeekeeperRepository repository;

    @Test
    public void create() throws Exception {

        Beekeeper beekeepers = BeekeeperFactory.create("karl", "otto", "karl1256@yahoo.com");

        repository.save(beekeepers);
        id=beekeepers.getId();
        Assert.assertNotNull(beekeepers.getId());
        System.out.println(beekeepers.getId());
    }


}
