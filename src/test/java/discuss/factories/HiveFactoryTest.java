package discuss.factories;

import discuss.conf.factories.BeekeeperFactory;
import discuss.conf.factories.HiveFactory;
import discuss.conf.factories.LocationFactory;
import discuss.domain.*;

import discuss.conf.factories.SubLocationFactory;
import discuss.domain.SubLocation;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/09/13.
 */
public class HiveFactoryTest {
    @Test
    public void testCreate() throws Exception {
        Beekeeper beekeepers = BeekeeperFactory.create("karl", "otto", "karl1256@yahoo.com");
        Location locations = LocationFactory.create("Darling",beekeepers );


        SubLocation subLocations = SubLocationFactory.create("Fossil", locations);
        Hive hives = HiveFactory.create("sss", subLocations);
        Assert.assertEquals(hives.getHiveState(), "sss");
    }

    @Test
    public void testUpdate() throws Exception {
        Beekeeper beekeepers = BeekeeperFactory.create("karl", "otto", "karl1256@yahoo.com");
        Location locations = LocationFactory.create("Darling", beekeepers);


        SubLocation subLocations = SubLocationFactory.create("Fossil", locations);


        Hive hives = HiveFactory.create("Fossil", subLocations);
        Hive newHives = new Hive
                .Builder("Fossil")
                .copy(hives)
                .subLocations(subLocations)
                .build();
        Assert.assertEquals(newHives.getHiveState(),"Fossil");
        Assert.assertEquals(hives.getHiveState(), "Fossil");

    }
}