package discuss.conf.factories;

import discuss.domain.VoteUp;

/**
 * Created by student on 2015/06/03.
 */
public class VoteUpFactory {
    public static VoteUp create(int name){
        VoteUp role = new VoteUp.Builder(name)
                .build();
        return role;
    }
}
