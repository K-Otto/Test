package discuss.respository;

import discuss.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by student on 2015/06/03.
 */
public interface UserRepository extends CrudRepository<User,Long> {
}
