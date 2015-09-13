package discuss.factories;

import discuss.conf.factories.SuperFactory;
import discuss.domain.Hive;
import discuss.domain.Super;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/09/13.
 */
public class SuperFactoryTest {
    @Test
    public void testCreate() throws Exception {
        List<Hive> hives = new ArrayList<Hive>();
        Super supers = SuperFactory.create("sss", hives);
        Assert.assertEquals(supers.getSuperState(), "sss");
    }

    @Test
    public void testUpdate() throws Exception {
        List<Hive> hives = new ArrayList<Hive>();


        Super supers = SuperFactory.create("Fossil", hives);
        Super newSupers = new Super
                .Builder("Fossil")
                .copy(supers)
                .hives(hives)
                .build();
        Assert.assertEquals(newSupers.getSuperState(),"Fossil");
        Assert.assertEquals(supers.getSuperState(), "Fossil");

    }
}
