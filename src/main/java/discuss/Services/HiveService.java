package discuss.Services;

import discuss.domain.Hive;
import discuss.domain.SubLocation;

/**
 * Created by student on 2015/09/25.
 */
public interface HiveService {
    String saveHive(String hiveState,
                    String subLocationName,
                    String locationName,
                    String firstname,
                    String lastname,
                    String email
    );

    Hive getHive(Long id);
}
