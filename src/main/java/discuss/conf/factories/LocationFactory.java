package discuss.conf.factories;

import discuss.domain.Beekeeper;
import discuss.domain.Location;

import java.util.List;

/**
 * Created by student on 2015/09/13.
 */
public class LocationFactory {
    public static Location create(String locationName, List<Beekeeper> beekeepers){
        Location locations = new Location.Builder‭(locationName)
                .beekeepers(beekeepers)
                .build();
        return locations ;
    }
}
