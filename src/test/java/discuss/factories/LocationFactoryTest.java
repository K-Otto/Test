package discuss.factories;

import discuss.conf.factories.BeekeeperFactory;

import org.testng.Assert;
import org.testng.annotations.Test;
import discuss.conf.factories.LocationFactory;
import discuss.domain.Beekeeper;
import discuss.domain.Location;


/**
 * Created by student on 2015/09/13.
 */
public class LocationFactoryTest {
    @Test
    public void testCreate() throws Exception {
        Beekeeper beekeepers = BeekeeperFactory.create("karl", "otto", "karl1256@yahoo.com");
        Location location = LocationFactory.create("Darling", beekeepers);
        Assert.assertEquals(location.getLocationName‭‭(), "Darling");
    }

    @Test
    public void testUpdate() throws Exception {
        Beekeeper beekeepers = BeekeeperFactory.create("karl", "otto", "karl1256@yahoo.com");


        Location location = LocationFactory.create("Cape", beekeepers);
        Location newLocation = new Location
                .Builder‭("Darling")
                .copy(location)
                .beekeepers(beekeepers)
                .build();
        Assert.assertEquals(newLocation.getLocationName‭‭(),"Cape");
        Assert.assertEquals(location.getLocationName‭‭(), "Cape");

    }
}
