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

    private Long id;
    private Beekeeper beekeeperGlobal;

    @Autowired
    private BeekeeperService service;

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
        service.saveBeekeeper(beekeepers.getFirstName(),
                beekeepers.getLastName(),
                beekeepers.getEmail(),
                locations.getLocationName‭‭(),
                sublocations.getSubLocationName(),
                hives.getHiveState(),
                supers.getSuperState());

        
        id = beekeepers.getId();
        beekeeperGlobal = beekeepers;
        Assert.assertNotNull(beekeepers);
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        // Get subject
        String idtest = id + "";
        Long longId = Long.parseLong(idtest);
        Beekeeper beekeepers = service.getBeekeeper(longId);
        beekeeperGlobal = service.getBeekeeper(longId);
        Assert.assertNotNull(beekeeperGlobal);
    }

}




