package discuss.respository;

import discuss.domain.Location;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by student on 2015/09/13.
 */
public interface LocationRepository extends CrudRepository<Location,Long> {
}
