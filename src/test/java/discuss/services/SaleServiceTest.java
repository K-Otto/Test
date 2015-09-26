package discuss.services;

import discuss.App;
import discuss.Services.SaleService;
import discuss.conf.factories.*;
import discuss.domain.*;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;


/**
 * Created by student on 2015/09/24.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class SaleServiceTest extends AbstractTestNGSpringContextTests {

    private Long id;
    private Sales saleGlobal;

    @Autowired
    private SaleService service;

    @Test
    public void create() throws Exception  {
        Beekeeper beekeepers = BeekeeperFactory
                .create("Karl", "Otto", "Karl@gmail.com");
        Location locations = LocationFactory
                .create("Darling", beekeepers);
        Customer customers = CustomerFactory
                .create("Piet", "pieter", "Karl@gmail.com");

        SubLocation sublocations = SubLocationFactory
                .create("Waterhole", locations);
        Harvest harvests = HarvestFactory
                .create("December", 22.00, sublocations);
        Bucket buckets = BucketFactory
                .create(22.00, harvests);
        Sales sales = SalesFactory
                .create("December", 22.00, buckets,customers);

        service.saveSales(sales.getSalesDate(),
                sales.getPrice(),
                sales.getBuckets(),
                sales.getCustomers());


        id = sales.getId();
        saleGlobal = sales;
        Assert.assertNotNull(sales);
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        // Get subject
        String idtest = id + "";
        Long longId = Long.parseLong(idtest);
        Sales sales = service.getSales(longId);
        saleGlobal = service.getSales(longId);
        Assert.assertNotNull(saleGlobal);
    }

}