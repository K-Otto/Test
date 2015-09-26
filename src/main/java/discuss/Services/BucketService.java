package discuss.Services;

import discuss.domain.Bucket;
import discuss.domain.Harvest;

/**
 * Created by student on 2015/09/25.
 */
public interface BucketService {
    String saveBucket(
                       double bucWeight,
                       String harvestDate,
                       double harWeight,
                       String subLocationName,
                       String locationName,
                       String bFirstname,
                       String bLastname,
                       String bEmail

    );

    Bucket getBucket(Long id);
}