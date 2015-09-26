package discuss.services;
import discuss.App;
import discuss.Services.HarvestService;
import discuss.conf.factories.BeekeeperFactory;
import discuss.conf.factories.HarvestFactory;
import discuss.conf.factories.LocationFactory;
import discuss.conf.factories.SubLocationFactory;
import discuss.domain.Beekeeper;
import discuss.domain.Harvest;
import discuss.domain.Location;
import discuss.domain.SubLocation;
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
public class HarvestServiceTest extends AbstractTestNGSpringContextTests {

    private Long id;
    private Harvest harvestGlobal;

    @Autowired
    private HarvestService service;

    @Test
    public void create() throws Exception {
        Beekeeper beekeepers = BeekeeperFactory
                .create("Karl", "Otto", "Karl@gmail.com");
        Location locations = LocationFactory
                .create("Darling", beekeepers);
        SubLocation sublocations = SubLocationFactory
                .create("Waterhole", locations);
        Harvest harvests = HarvestFactory
                .create("December", 22.00,sublocations);

        service.saveHarvest(harvests.getHarvestDate(),
                harvests.getWeight(),
                sublocations.getSubLocationName(),
                locations.getLocationName‭‭(),
                beekeepers.getFirstName(),
                beekeepers.getLastName(),
                beekeepers.getEmail());



        id = harvests.getId();
        harvestGlobal = harvests;
        Assert.assertNotNull(harvests);
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        // Get subject
     //   String idtest = id + "";
     //   Long longId = Long.parseLong(idtest);
    //    Harvest harvests = service.getHarvest(longId);
     //   harvestGlobal = service.getHarvest(longId);
      //  Assert.assertNotNull(harvestGlobal);
    }

}
