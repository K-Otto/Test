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
            double bucWeight,
            String harvestDate,
            double harWeight,
            String subLocationName,
            String locationName,
            String bFirstname,
            String bLastname,
            String bEmail,
            String cFirstname,
            String cLastname,
            String cEmail

    );

    Sales getSales(Long id);
}