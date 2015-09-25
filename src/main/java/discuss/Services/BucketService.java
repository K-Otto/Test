package discuss.Services;

import discuss.domain.Bucket;
import discuss.domain.Harvest;

/**
 * Created by student on 2015/09/25.
 */
public interface BucketService {
    String saveBucket(
                       double weight,
                       Harvest harvests
    );

    Bucket getBucket(Long id);
}