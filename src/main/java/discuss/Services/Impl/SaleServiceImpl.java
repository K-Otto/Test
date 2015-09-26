package discuss.Services.Impl;

import discuss.Services.SaleService;
import discuss.conf.factories.SalesFactory;
import discuss.domain.Bucket;
import discuss.domain.Customer;
import discuss.domain.Harvest;
import discuss.domain.Sales;
import discuss.respository.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by student on 2015/09/25.
 */
@Service
public class SaleServiceImpl implements SaleService {
    @Autowired
    SalesRepository repository;


    @Override
    public String saveSales(String salesDate,
            double price,
            Bucket buckets,
            Customer customers) {
        Sales sales = SalesFactory
                .create(salesDate,price, buckets,customers);

        return repository.save(sales).toString();

    }

    @Override
    public Sales getSales (Long id) {

        return repository.findOne(id);
    }
}
