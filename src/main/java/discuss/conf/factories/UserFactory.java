package discuss.conf.factories;

import discuss.domain.Reputation;
import discuss.domain.User;

import java.util.List;

/**
 * Created by student on 2015/06/03.
 */
public class UserFactory {
    public static User create(String email, String screenName, String password, String status, List<Reputation> reputations){
        User user = new User.Builder(email)
                .screenName(screenName)
                .password(password)
                .status(status)
                .reputations(reputations)
                .build();
        return user;
    }
}