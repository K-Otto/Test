package discuss.factories;

import discuss.conf.factories.SubLocationFactory;
import discuss.domain.Location;
import discuss.domain.SubLocation;
import org.testng.Assert;
import org.testng.annotations.Test;
import discuss.conf.factories.LocationFactory;
import discuss.domain.Beekeeper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/09/13.
 */
public class SubLocationFactoryTest {
    @Test
    public void testCreate() throws Exception {
        List<Location> locations = new ArrayList<Location>();
        SubLocation location = SubLocationFactory.create("Olives", locations);
        Assert.assertEquals(location.getSubLocationName(), "Olives");
    }

    @Test
    public void testUpdate() throws Exception {
        List<Location> locations = new ArrayList<Location>();


        SubLocation subLocations = SubLocationFactory.create("Fossil", locations);
        SubLocation newSubLocation = new SubLocation
                .Builder("Fossil")
                .copy(subLocations)
                .locations(locations)
                .build();
        Assert.assertEquals(newSubLocation.getSubLocationName(),"Fossil");
        Assert.assertEquals(subLocations.getSubLocationName(), "Fossil");

    }
}

