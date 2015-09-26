package discuss.services;
import discuss.App;

import discuss.Services.SuperService;
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
public class SuperServiceTest extends AbstractTestNGSpringContextTests{

    private Long id;
    private Super superGlobal;

    @Autowired
    private SuperService service;

    @Test
    public void create() throws Exception {
        Beekeeper beekeepers = BeekeeperFactory
                .create("Karl", "Otto", "Karl@gmail.com");
        Location locations = LocationFactory
                .create("Darling", beekeepers);
        SubLocation sublocations = SubLocationFactory
                .create("Waterhole", locations);
        Hive hives = HiveFactory
                .create("Active", sublocations);
        Super supers = SuperFactory
                .create("Active", hives);
        service.saveSuper(supers.getSuperState(),
                supers.getHives());


        id = supers.getId();
        superGlobal = supers;
        Assert.assertNotNull(supers);
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        // Get subject
        String idtest = id + "";
        Long longId = Long.parseLong(idtest);
        Super supers = service.getSuper(longId);
        superGlobal = service.getSuper(longId);
        Assert.assertNotNull(superGlobal);
    }

}
