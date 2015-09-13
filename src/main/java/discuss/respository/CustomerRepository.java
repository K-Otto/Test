package discuss.respository;

import discuss.domain.Customer;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by student on 2015/09/13.
 */
public interface CustomerRepository extends CrudRepository<Customer,Long> {
}
