package discuss.factories;

import discuss.conf.factories.*;
import discuss.domain.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/09/13.
 */
public class BucketFactoryTest {
    @Test
    public void testCreate() throws Exception {
        Beekeeper beekeepers = BeekeeperFactory.create("karl", "otto", "karl1256@yahoo.com");
        Location locations = LocationFactory.create("Darling", beekeepers);
        SubLocation subLocations = SubLocationFactory.create("Fossil", locations);
        Harvest harvests = HarvestFactory.create("Fossil", 66.00, subLocations);

        Bucket hives = BucketFactory.create(66.00, harvests);
        Assert.assertEquals(hives.getWeight(), 66.00);
    }

    @Test
    public void testUpdate() throws Exception {
        Beekeeper beekeepers = BeekeeperFactory.create("karl", "otto", "karl1256@yahoo.com");
        Location locations = LocationFactory.create("Darling",beekeepers );


        SubLocation subLocations = SubLocationFactory.create("Fossil", locations);


        Harvest harvests = HarvestFactory.create("Fossil", 66.00, subLocations);


        Bucket buckets = BucketFactory.create( 66.00, harvests);
        Bucket newBucket = new Bucket
                .Builder(buckets.getWeight())

                .copy(buckets)
                .harvests(harvests)
                .build();
        Assert.assertEquals(newBucket.getWeight(), 66.00);
        Assert.assertEquals(buckets.getWeight(), 66.00);

    }
}

