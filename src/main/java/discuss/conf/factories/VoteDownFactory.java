package discuss.conf.factories;

import discuss.domain.VoteDown;

/**
 * Created by student on 2015/06/03.
 */
public class VoteDownFactory {
public static VoteDown create(int name){
    VoteDown role = new VoteDown.Builder(name)
            .build();
    return role;
}
}
