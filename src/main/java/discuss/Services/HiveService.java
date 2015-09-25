package discuss.Services;

import discuss.domain.Hive;
import discuss.domain.SubLocation;

/**
 * Created by student on 2015/09/25.
 */
public interface HiveService {
    String saveHive(String subLocationName,
                           SubLocation subLocations
    );

    Hive getHive(Long id);
}
