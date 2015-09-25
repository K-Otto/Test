package discuss.Services;

import discuss.domain.Hive;
import discuss.domain.Super;

/**
 * Created by student on 2015/09/25.
 */
public interface SuperService {
    String saveSuper(String subLocationName,
                    Hive hives
    );

    Super getSuper(Long id);
}

