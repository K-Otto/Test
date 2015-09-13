package discuss.factories;

import discuss.conf.factories.RoleFactory;
import discuss.domain.Role;
import org.junit.Test;
import org.testng.Assert;

/**
 * Created by [Karl Otto 212026992 ] on 2015/06/03.Karl Otto 212026992
 *
 */
public class RoleFactoryTest {
    @Test
    public void testCreate() throws Exception {
        Role role = RoleFactory.create("ADMIN","System Administrator");
        Assert.assertEquals(role.getName(),"ADMIN");
    }

    @Test
    public void testUpdate() throws Exception {
        Role role = RoleFactory.create("ADMIN","System Administrator");
        Role newrole = new Role
                .Builder(role.getName())
                .copy(role)
                .description("SYS ADMIN")
                .build();
        Assert.assertEquals(newrole.getDescription(),"SYS ADMIN");
        Assert.assertEquals(role.getDescription(),"System Administrator");

    }
}
