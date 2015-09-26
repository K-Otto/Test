package discuss.Services;

import discuss.domain.Hive;
import discuss.domain.Super;

/**
 * Created by student on 2015/09/25.
 */
public interface SuperService {
    String saveSuper(String superState,
                     String hiveState,
                     String subLocationName,
                     String locationName,
                     String firstname,
                     String lastname,
                     String email
    );

    Super getSuper(Long id);
}

