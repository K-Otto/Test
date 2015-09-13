package discuss.factories;

import discuss.conf.factories.ContentFilterFactory;
import discuss.conf.factories.ResponseFactory;
import discuss.domain.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by student on 2015/06/03.Karl Otto 212026992
 */
public class ResponseFactoryTest {
    @Test
    public void testCreate() throws Exception {
        Date date = new Date();
        List<VoteUp> sites = new ArrayList<VoteUp>();
        List<VoteDown> roles = new ArrayList<VoteDown>();
        List<AbuseReport> abuses = new ArrayList<AbuseReport>();
        List<User> users = new ArrayList<User>();
        ContentFilter address = ContentFilterFactory.create("123");
        Response role = ResponseFactory.create("Hello world",date,"10.0.0.2", address, users,sites,roles,abuses);
        Assert.assertEquals(role.getComment(), "Hello world");
    }

    @Test
    public void testUpdate() throws Exception {
        Date date = new Date();

        List<VoteUp> sites = new ArrayList<VoteUp>();
        List<VoteDown> roles = new ArrayList<VoteDown>();
        List<AbuseReport> abuses = new ArrayList<AbuseReport>();
        List<User> users = new ArrayList<User>();
        ContentFilter address = ContentFilterFactory.create("123");
        Response role = ResponseFactory.create("Hello world",date,"10.0.0.2", address, users,sites,roles,abuses);
        Response newrole = new Response
                .Builder(role.getComment())
                .copy(role)
                .ipaddress("10.0.0.3")
                .build();
        Assert.assertEquals(newrole.getIpaddress(),"10.0.0.3");
        Assert.assertEquals(role.getIpaddress(),"10.0.0.2");

    }
}
