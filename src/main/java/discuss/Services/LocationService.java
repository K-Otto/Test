package discuss.Services;

import discuss.domain.Beekeeper;
import discuss.domain.Location;

/**
 * Created by student on 2015/09/23.
 */
public interface LocationService {
    String saveLocation(String locationName,
                         Beekeeper beekeeper
    );

    Location getLocation(Long id);
}
