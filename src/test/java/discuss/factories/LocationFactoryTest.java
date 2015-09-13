package discuss.factories;

import discuss.conf.factories.UserFactory;
import discuss.domain.Reputation;
import discuss.domain.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import discuss.conf.factories.LocationFactory;
import discuss.domain.Beekeeper;
import discuss.domain.Location;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/09/13.
 */
public class LocationFactoryTest {
    @Test
    public void testCreate() throws Exception {
        List<Beekeeper> beekeepers = new ArrayList<Beekeeper>();
        Location location = LocationFactory.create("Darling", beekeepers);
        Assert.assertEquals(location.getLocationName‭‭(), "Darling");
    }

    @Test
    public void testUpdate() throws Exception {
        List<Beekeeper> beekeepers = new ArrayList<Beekeeper>();


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
