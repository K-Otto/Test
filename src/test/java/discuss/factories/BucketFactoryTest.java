package discuss.factories;

import discuss.conf.factories.BucketFactory;
import discuss.domain.Bucket;
import discuss.domain.Harvest;
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
        List<Harvest> harvests = new ArrayList<Harvest>();
        Bucket hives = BucketFactory.create(66.00, harvests);
        Assert.assertEquals(hives.getWeight(), 66.00);
    }

    @Test
    public void testUpdate() throws Exception {
        List<Harvest> harvests = new ArrayList<Harvest>();


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

