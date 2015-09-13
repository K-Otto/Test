package discuss.factories;

import discuss.conf.factories.CustomerFactory;
import discuss.domain.Customer;
import org.testng.Assert;
import org.testng.annotations.Test;
/**
 * Created by student on 2015/09/13.
 */
public class CustomerFactoryTest {
    @Test
    public void testCreate() throws Exception {
        Customer role = CustomerFactory.create("Karl", "Piet", "Karl@gmail.com");
        Assert.assertEquals(role.getFirstName(),"Karl");
    }

    @Test
    public void testUpdate() throws Exception {
        Customer role = CustomerFactory.create("Karl", "Otto", "Karl@gmail.com");
        Customer newBeekeeper = new Customer
                .Builder(role.getFirstName())
                .copy(role)
                .email("Karl@gmail.com")
                .build();
        Assert.assertEquals(newBeekeeper.getEmail(),"Karl@gmail.com");
        Assert.assertEquals(role.getLastName(),"Otto");

    }
}