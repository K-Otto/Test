package discuss.conf.factories;

import discuss.domain.Beekeeper;

/**
 * Created by student on 2015/09/13.
 */
public class BeekeeperFactory {
    public static Beekeeper create(String firstName, String lastName, String email){
        Beekeeper beekeepers = new Beekeeper.Builder(lastName)
                .firstName(firstName)
                .email(email)
                .build();
        return beekeepers ;
    }
}
