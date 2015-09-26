package discuss.services;

import discuss.App;
import discuss.Services.LocationService;
import discuss.conf.factories.BeekeeperFactory;
import discuss.conf.factories.LocationFactory;
import discuss.domain.Beekeeper;
import discuss.domain.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;
/**
 * Created by student on 2015/09/26.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class LocationServiceTest extends AbstractTestNGSpringContextTests {

    private Long id;
    private Location locationGlobal;

    @Autowired
    private LocationService service;

    @Test
    public void create() throws Exception {
        Beekeeper beekeepers = BeekeeperFactory
                .create("Karl", "Otto", "Karl@gmail.com");
        Location locations = LocationFactory
                .create("Darling", beekeepers);

        service.saveLocation(locations.getLocationName‭‭(),
                locations.getBeekeepers());


        id = locations.getId();
        locationGlobal = locations;
        Assert.assertNotNull(locations);
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        // Get subject
        String idtest = id + "";
        Long longId = Long.parseLong(idtest);
        Location locations = service.getLocation(longId);
        locationGlobal = service.getLocation(longId);
        Assert.assertNotNull(locationGlobal);
    }

}