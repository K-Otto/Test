package discuss.Services;

import discuss.domain.Location;
import discuss.domain.SubLocation;

/**
 * Created by student on 2015/09/25.
 */
public interface SubLocationService {
    String saveSubLocation(String subLocationName,
                           String locationName,
                           String firstname,
                           String lastname,
                           String email
    );

    SubLocation getSubLocation(Long id);
}
