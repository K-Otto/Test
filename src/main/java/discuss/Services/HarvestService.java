package discuss.Services;

import discuss.domain.Harvest;
import discuss.domain.SubLocation;

/**
 * Created by student on 2015/09/25.
 */
public interface HarvestService {
    String saveHarvest(String harvestDate,
                       double harWeight,
                       String subLocationName,
                       String locationName,
                       String firstname,
                       String lastname,
                       String email
    );

    Harvest getHarvest(Long id);
}
