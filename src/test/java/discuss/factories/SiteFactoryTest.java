package discuss.factories;

import discuss.conf.factories.SiteFactory;
import discuss.domain.Site;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by student on 2015/06/03.Karl Otto 212026992
 */
public class SiteFactoryTest {
    @Test
    public void testCreate() throws Exception {

        Site role = SiteFactory.create("berry","berry.com","berry.com/berry");
    }

    @Test
    public void testUpdate() throws Exception {

        Site role = SiteFactory.create("berry","berry.com","berry.com/berry");
        Site newrole = new Site
                .Builder(role.getName())
                .copy(role)
                .url("berry.com")
                .storyurl("berry.com/berry12")
                .build();
        Assert.assertEquals(newrole.getStoryurl(),"berry.com/berry12");
        Assert.assertEquals(role.getStoryurl(),"berry.com/berry");

    }
}
