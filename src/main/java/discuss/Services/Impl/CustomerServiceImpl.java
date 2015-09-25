package discuss.Services.Impl;

import discuss.Services.CustomerService;
import discuss.conf.factories.CustomerFactory;
import discuss.domain.Customer;
import discuss.respository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by student on 2015/09/25.
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository repository;


    @Override
    public String saveCustomer(String firstName,
                                String lastName,
                                String Email) {
        Customer customers = CustomerFactory
                .create(firstName, lastName, Email);

        return repository.save(customers).toString();

    }

    @Override
    public Customer getCustomer (Long id) {

        return repository.findOne(id);
    }
}

