package discuss.services;

import discuss.App;
import discuss.conf.factories.RoleFactory;
import discuss.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;
/**
 * Created by [PUT NAME AND STUDENT NUMBER HERE ] on 2015/06/03.
 *
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class Question0Test extends AbstractTestNGSpringContextTests {
    @Autowired
    private RoleService service;
    private Long id;


    @Test
    public void create() throws Exception {
        // FIRST CREATE THE ROLE OBJECT AND SAVE IT IN DB
        Role role = RoleFactory.create("ADMIN", "System Administrator");
        service.saveRole(role);
        id=role.getId();
        Assert.assertNotNull(role);
    }

    @Test(dependsOnMethods = "create")
    public void findDescriptionWhenGivenRole() throws Exception {
        // WE NOW TEST THE DESCRIPTION
        String description = service.getRoleDescription("ADMIN");
        Assert.assertEquals(description,"System Administrator");

    }
//    Uncomment to clean up Table for Role Table
//    @Test(dependsOnMethods = "findDescriptionWhenGivenRole")
    public void cleanUp() throws Exception {
        // CLEAN THE MESS WE PUT IN THE DATABASE
        service.cleanUp();
        Role deletedRole = service.findRoleById(id);
        Assert.assertNull(deletedRole);
    }



}
