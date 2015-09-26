package discuss.services;

import discuss.App;
import discuss.Services.BucketService;
import discuss.Services.HarvestService;
import discuss.conf.factories.*;
import discuss.domain.*;
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
public class BucketServiceTest extends AbstractTestNGSpringContextTests {

    private Long id;
    private Bucket bucketGlobal;

    @Autowired
    private BucketService service;

    @Test
    public void create() throws Exception {
        Beekeeper beekeepers = BeekeeperFactory
                .create("Karl", "Otto", "Karl@gmail.com");
        Location locations = LocationFactory
                .create("Darling", beekeepers);
        SubLocation sublocations = SubLocationFactory
                .create("Waterhole", locations);
        Harvest harvests = HarvestFactory
                .create("December", 22.00, sublocations);
        Bucket buckets = BucketFactory
                .create(22.00, harvests);


        service.saveBucket(
                buckets.getWeight(),
                harvests.getHarvestDate(),
                harvests.getWeight(),
                sublocations.getSubLocationName(),
                locations.getLocationName‭‭(),
                beekeepers.getFirstName(),
                beekeepers.getLastName(),
                beekeepers.getEmail()
               );


        id = buckets.getId();
        bucketGlobal = buckets;
        Assert.assertNotNull(buckets);
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        // Get subject
      //  String idtest = id + "";
      //  Long longId = Long.parseLong(idtest);
      //  Bucket buckets = service.getBucket(longId);
      //  bucketGlobal = service.getBucket(longId);
      //  Assert.assertNotNull(bucketGlobal);
    }

}
