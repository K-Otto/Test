package discuss.factories;
import discuss.conf.factories.SalesFactory;
import discuss.conf.factories.SubLocationFactory;
import discuss.domain.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import discuss.conf.factories.LocationFactory;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by student on 2015/09/13.
 */
public class SalesFactoryTest {
    @Test
    public void testCreate() throws Exception {
        List<Customer> jobs = new ArrayList<Customer>();
        List<Bucket> buc = new ArrayList<Bucket>();
        Sales aa = SalesFactory.create("Olives", 22.22, buc, jobs);
        Assert.assertEquals(aa.getSalesDate(), "Olives");
    }

    @Test
    public void testUpdate() throws Exception {
        List<Customer> jobs = new ArrayList<Customer>();
        List<Bucket> buc = new ArrayList<Bucket>();


        Sales role = SalesFactory.create("date", 22.00,buc, jobs);
        Sales newSubLocation = new Sales
                .Builder(role.getSalesDate())
                .copy(role)
                .price(22.00)
                .customers(jobs)
                .buckets(buc)
                .build();
        Assert.assertEquals(newSubLocation.getSalesDate(),"date");
        Assert.assertEquals(role.getSalesDate(), "date");

    }
}