package discuss.Services;

import discuss.domain.Customer;

/**
 * Created by student on 2015/09/25.
 */
public interface CustomerService {
    String saveCustomer(String firstName,
                         String lastName,
                         String Email
    );

    Customer getCustomer(Long id);
}
