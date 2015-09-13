package discuss.factories;

import discuss.conf.factories.ContactFactory;
import discuss.conf.factories.SiteManagerFactory;
import discuss.domain.Contact;
import discuss.domain.Role;
import discuss.domain.Site;
import discuss.domain.SiteManager;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/06/03.Karl Otto 212026992
 */
public class SiteManagerFactoryTest {
    @Test
    public void testCreate() throws Exception {
        List<Site> sites = new ArrayList<Site>();
        List<Role> roles = new ArrayList<Role>();
        Contact address = ContactFactory.create("123", "10", "addressValues");
        SiteManager role = SiteManagerFactory.create("karl@gmail.com","sam","sam","1234",address,sites,roles);
        Assert.assertEquals(role.getEmail(), "karl@gmail.com");
    }

    @Test
    public void testUpdate() throws Exception {
        List<Site> sites = new ArrayList<Site>();
        List<Role> roles = new ArrayList<Role>();
        Contact address = ContactFactory.create("123", "10", "addressValues");
        SiteManager role = SiteManagerFactory.create("karl@gmail.com", "sam", "sam", "1234",address,sites,roles);
        SiteManager newrole = new SiteManager
                .Builder(role.getEmail())
                .copy(role)
                .firstname("sam")
                .lastname("sam")
                .password("12345")
                .build();
        Assert.assertEquals(newrole.getPassword(),"12345");
        Assert.assertEquals(role.getPassword(),"1234");

    }
}

