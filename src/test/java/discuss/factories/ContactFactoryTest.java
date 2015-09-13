package discuss.factories;

import discuss.conf.factories.ContactFactory;
import discuss.domain.Contact;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by student on 2015/06/03.Karl Otto 212026992
 */
public class ContactFactoryTest {
    @Test
    public void testCreate() throws Exception {

        Contact role = ContactFactory.create("0834442678","14 park ave","7333");
        Assert.assertEquals(role.getCellphone(), "0834442678");
    }

    @Test
    public void testUpdate() throws Exception {

        Contact role = ContactFactory.create("0834442678","14 park ave","7333");
        Contact newrole = new Contact
                .Builder(role.getCellphone())
                .copy(role)
                .address("14 park ave")
                .postalcode("7233")
                .build();
        Assert.assertEquals(newrole.getPostalcode(),"7233");
        Assert.assertEquals(role.getPostalcode(),"7333");

    }
}
