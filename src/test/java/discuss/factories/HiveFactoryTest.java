package discuss.factories;

import discuss.conf.factories.HiveFactory;
import discuss.domain.Hive;
import discuss.domain.SubLocation;

import discuss.conf.factories.SubLocationFactory;
import discuss.domain.Location;
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
        List<SubLocation> subLocations = new ArrayList<SubLocation>();
        Hive hives = HiveFactory.create("sss", subLocations);
        Assert.assertEquals(hives.getHiveState(), "sss");
    }

    @Test
    public void testUpdate() throws Exception {
        List<SubLocation> subLocations = new ArrayList<SubLocation>();


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