package discuss.factories;

import discuss.conf.factories.ReputationFactory;
import discuss.domain.Reputation;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Date;

/**
 * Created by student on 2015/06/03.Karl Otto 212026992
 */
public class ReputationFactoryTest {
    @Test
    public void testCreate() throws Exception {
        Date date = new Date();
        Reputation role = ReputationFactory.create(date, 4);
        Assert.assertEquals(role.getDate(), date);
    }

    @Test
    public void testUpdate() throws Exception {
        Date date = new Date();
        Reputation role = ReputationFactory .create(date, 4);
        Reputation newrole = new Reputation
                .Builder(role.getDate())
                .copy(role)
                .value(3)
                .build();
        Assert.assertEquals(newrole.getValue(),3);
        Assert.assertEquals(role.getValue(),4);

    }
}