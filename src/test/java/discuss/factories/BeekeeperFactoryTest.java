package discuss.factories;

import discuss.conf.factories.BeekeeperFactory;

import discuss.domain.Beekeeper;

import org.testng.Assert;
import org.testng.annotations.Test;



/**
 * Created by student on 2015/09/13.
 */
public class BeekeeperFactoryTest {
    @Test
    public void testCreate() throws Exception {
        Beekeeper role = BeekeeperFactory.create("Karl","Piet", "Karl@gmail.com");
        Assert.assertEquals(role.getFirstName(),"Karl");
    }

    @Test
    public void testUpdate() throws Exception {
        Beekeeper role = BeekeeperFactory.create("Karl", "Otto", "Karl@gmail.com");
        Beekeeper newBeekeeper = new Beekeeper
                .Builder(role.getFirstName())
                .copy(role)
                .email("Karl@gmail.com")
                .build();
        Assert.assertEquals(newBeekeeper.getEmail(),"Karl@gmail.com");
        Assert.assertEquals(role.getLastName(),"Otto");

    }
}