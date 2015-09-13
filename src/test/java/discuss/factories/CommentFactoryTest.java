package discuss.factories;

import discuss.conf.factories.CommentFactory;
import discuss.conf.factories.ContentFilterFactory;
import discuss.domain.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by student on 2015/06/03.Karl Otto 212026992
 */
public class CommentFactoryTest {
    @Test
    public void testCreate() throws Exception {
        Date date = new Date();
        List<VoteUp> sites = new ArrayList<VoteUp>();
        List<VoteDown> roles = new ArrayList<VoteDown>();
        List<AbuseReport> abuses = new ArrayList<AbuseReport>();
        List<User> users = new ArrayList<User>();
        List<Site> bb = new ArrayList<Site>();
        List<Response> aa = new ArrayList<Response>();
        ContentFilter address = ContentFilterFactory.create("123");
        Comment role = CommentFactory.create("Hello world",date,"10.0.0.2", address,users,sites,roles,aa,bb, abuses);
        Assert.assertEquals(role.getComment(), "Hello world");
    }

    @Test
    public void testUpdate() throws Exception {
        Date date = new Date();

        List<VoteUp> sites = new ArrayList<VoteUp>();
        List<VoteDown> roles = new ArrayList<VoteDown>();
        List<AbuseReport> abuses = new ArrayList<AbuseReport>();
        List<User> users = new ArrayList<User>();
        List<Site> bb = new ArrayList<Site>();
        List<Response> aa = new ArrayList<Response>();
        ContentFilter address = ContentFilterFactory.create("123");
        Comment role = CommentFactory.create("Hello world",date,"10.0.0.2", address,users,sites,roles,aa,bb, abuses);
        Comment newrole = new Comment
                .Builder(role.getComment())
                .copy(role)
                .ipaddress("10.0.0.3")
                .build();
        Assert.assertEquals(newrole.getIpaddress(),"10.0.0.3");
        Assert.assertEquals(role.getIpaddress(),"10.0.0.2");

    }
}
