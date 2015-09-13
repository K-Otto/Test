package discuss.conf.factories;

import discuss.domain.Contact;
import discuss.domain.Role;
import discuss.domain.Site;
import discuss.domain.SiteManager;

import java.util.List;

/**
 * Created by student on 2015/06/03.
 */
public class SiteManagerFactory {
    public static SiteManager create(String email, String firstname, String lastname, String password,Contact contact,List<Site> sites,List<Role> roles){
        SiteManager sitemanager = new SiteManager.Builder(email)
                .firstname(firstname)
                .lastname(lastname)
                .password(password)
                .contacts(contact)
                .sites(sites)
                .roles(roles)
                .build();
        return sitemanager;
    }
}