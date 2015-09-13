package discuss.respository;

import discuss.domain.Harvest;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by student on 2015/09/13.
 */
public interface HarvestRepository extends CrudRepository<Harvest,Long> {
}
