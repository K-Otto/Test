package discuss.conf.factories;

import discuss.domain.Reputation;

import java.util.Date;

/**
 * Created by student on 2015/06/03.
 */
public class ReputationFactory {
    public static Reputation create(Date date, int value){
        Reputation reputation = new Reputation.Builder(date)
                .value(value)
                .build();
        return reputation;
    }
}
