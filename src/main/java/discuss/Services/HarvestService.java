package discuss.Services;

import discuss.domain.Harvest;
import discuss.domain.SubLocation;

/**
 * Created by student on 2015/09/25.
 */
public interface HarvestService {
    String saveHarvest(String harvestDate,
                       double weight,
                           SubLocation subLocations
    );

    Harvest getHarvest(Long id);
}
