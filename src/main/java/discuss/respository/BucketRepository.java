package discuss.respository;

import discuss.domain.Bucket;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by student on 2015/09/13.
 */
public interface BucketRepository extends CrudRepository<Bucket,Long> {
}
