package discuss.respository;

import discuss.domain.Comment;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by student on 2015/06/03.Karl Otto 212026992
 */
public interface CommentRepository extends CrudRepository<Comment,Long> {
}
