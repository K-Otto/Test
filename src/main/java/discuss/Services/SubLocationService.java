package discuss.Services;

import discuss.domain.Location;
import discuss.domain.SubLocation;

/**
 * Created by student on 2015/09/25.
 */
public interface SubLocationService {
    String saveSubLocation(String subLocationName,
                        Location locations
    );

    SubLocation getSubLocation(Long id);
}
