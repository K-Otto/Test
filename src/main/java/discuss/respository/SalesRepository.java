package discuss.respository;

import discuss.domain.Sales;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by student on 2015/09/13.
 */
public interface SalesRepository extends CrudRepository<Sales,Long> {
}
