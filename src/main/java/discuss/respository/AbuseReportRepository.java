package discuss.respository;

import discuss.domain.AbuseReport;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by student on 2015/06/03.
 */
public interface AbuseReportRepository extends CrudRepository<AbuseReport,Long> {
}