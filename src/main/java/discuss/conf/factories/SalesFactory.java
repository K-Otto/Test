package discuss.conf.factories;

import discuss.domain.Bucket;
import discuss.domain.Customer;
import discuss.domain.Sales;

import java.util.List;

/**
 * Created by student on 2015/09/13.
 */
public class SalesFactory {
    public static Sales create(String salesDate,Double price, Bucket buckets, Customer customers){
        Sales sales= new Sales.Builder(salesDate)
                .price(price)
                .buckets(buckets)
                .customers(customers)
                .build();
        return sales;
    }
}
