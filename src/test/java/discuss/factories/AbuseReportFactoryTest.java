package discuss.factories;

import discuss.conf.factories.AbuseReportFactory;
import discuss.domain.AbuseReport;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by student on 2015/06/03.Karl Otto 212026992
 */
public class AbuseReportFactoryTest {
    @Test
    public void testCreate() throws Exception {
        AbuseReport role = AbuseReportFactory.create("ADMIN");
        Assert.assertEquals(role.getName(), "ADMIN");
    }

    @Test
    public void testUpdate() throws Exception {
        AbuseReport role = AbuseReportFactory.create("ADMIN");
        AbuseReport newrole = new AbuseReport
                .Builder(role.getName())
                .copy(role)

                .build();
        Assert.assertEquals(newrole.getName(),"SYS ADMIN");
        Assert.assertEquals(role.getName(),"System Administrator");

    }
}
