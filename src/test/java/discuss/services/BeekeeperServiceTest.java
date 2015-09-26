package discuss.services;
import discuss.App;
import discuss.Services.BeekeeperService;
import discuss.conf.factories.*;
import discuss.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;


/**
 * Created by student on 2015/09/24.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class BeekeeperServiceTest  extends AbstractTestNGSpringContextTests {

    private long id;
    private Beekeeper beekeeperGlobal;

    @Autowired
    private BeekeeperService service;

    @Test
    public void create() throws Exception {
        Beekeeper beekeepers = BeekeeperFactory
                .create("Karl", "Otto", "Karl@gmail.com");

        service.saveBeekeeper(beekeepers.getFirstName(),
                beekeepers.getLastName(),
                beekeepers.getEmail());


        id = beekeepers.getBeeId();
        beekeeperGlobal = beekeepers;
        Assert.assertNotNull(beekeepers);
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        // Get subject
        String idtest = id + "";

        long longId = Long.parseLong(idtest);
        Beekeeper beekeepers = service.getBeekeeper(1);
        id = beekeepers.getBeeId();
        beekeeperGlobal = service.getBeekeeper(id);

        Assert.assertNotNull(beekeeperGlobal);

    }

}




