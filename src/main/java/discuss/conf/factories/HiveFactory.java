package discuss.conf.factories;

import discuss.domain.Hive;
import discuss.domain.SubLocation;

import java.util.List;

/**
 * Created by student on 2015/09/13.
 */
public class HiveFactory {
    public static Hive create(String state, List<SubLocation> subLocations ){
        Hive hives = new Hive.Builder(state)
                .subLocations (subLocations )
                .build();
        return hives ;
    }
}
