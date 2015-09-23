package discuss.factories;

import discuss.conf.factories.BeekeeperFactory;
import discuss.conf.factories.HarvestFactory;
import discuss.conf.factories.LocationFactory;
import discuss.conf.factories.SubLocationFactory;
import discuss.domain.Beekeeper;
import discuss.domain.Harvest;
import discuss.domain.Location;
import discuss.domain.SubLocation;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/09/13.
 */
public class HarvestFactoryTest {
    @Test
    public void testCreate() throws Exception {
        Beekeeper beekeepers = BeekeeperFactory.create("karl", "otto", "karl1256@yahoo.com");
        Location locations = LocationFactory.create("Darling", beekeepers);
        SubLocation subLocations = SubLocationFactory.create("Fossil", locations);
        Harvest hives = HarvestFactory.create("Fossil", 66.00, subLocations);
        Assert.assertEquals(hives.getWeight(), 66.00);
    }

    @Test
    public void testUpdate() throws Exception {
        Beekeeper beekeepers = BeekeeperFactory.create("karl", "otto", "karl1256@yahoo.com");
        Location locations = LocationFactory.create("Darling",beekeepers );


        SubLocation subLocations = SubLocationFactory.create("Fossil", locations);


        Harvest harvests = HarvestFactory.create("Fossil", 66.00, subLocations);
        Harvest newHarvest = new Harvest
                .Builder(harvests.getHarvestDate())
                .weight(55.55)
                .copy(harvests)
                .subLocations(subLocations)
                .build();
        Assert.assertEquals(newHarvest.getHarvestDate(),"Fossil");
        Assert.assertEquals(harvests.getHarvestDate(), "Fossil");

    }
}
