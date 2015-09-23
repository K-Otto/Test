package discuss.conf.factories;

import discuss.domain.Location;
import discuss.domain.SubLocation;

import java.util.List;

/**
 * Created by student on 2015/09/13.
 */
public class SubLocationFactory {
    public static SubLocation create(String subLocationName, Location locations ){
        SubLocation subLocations = new SubLocation.Builder(subLocationName)
                .locations(locations)
                .build();
        return subLocations;
    }
}
