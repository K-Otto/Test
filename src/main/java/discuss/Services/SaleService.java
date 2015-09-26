package discuss.Services;

import discuss.domain.Bucket;
import discuss.domain.Customer;
import discuss.domain.Sales;

/**
 * Created by student on 2015/09/25.
 */
public interface SaleService {
    String saveSales(
            String salesDate,
            double price,
            Bucket buckets,
            Customer customers
    );

    Sales getSales(Long id);
}