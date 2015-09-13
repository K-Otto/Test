package discuss.factories;

import discuss.conf.factories.UserFactory;
import discuss.domain.Reputation;
import discuss.domain.User;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by student on 2015/06/03.Karl Otto 212026992
 */
public class UserFactoryTest {
    @Test
    public void testCreate() throws Exception {
        List<Reputation> jobs = new ArrayList<Reputation>();
        User role = UserFactory.create("karl@gmail.com","karl","1242f","Hello world", jobs);
        Assert.assertEquals(role.getEmail(), "karl@gmail.com");
    }

    @Test
    public void testUpdate() throws Exception {
        List<Reputation> jobs = new ArrayList<Reputation>();




        User role = UserFactory.create("karl@gmail.com","karl","1242f","Hello world", jobs);
        User newrole = new User
                .Builder(role.getEmail())
                .copy(role)
                .status("Hello worlds")
                .build();
        Assert.assertEquals(newrole.getStatus(),"Hello worlds");
        Assert.assertEquals(role.getStatus(),"Hello world");

    }
}
