package discuss.conf.factories;

import discuss.domain.Customer;

/**
 * Created by student on 2015/09/13.
 */
public class CustomerFactory {

        public static Customer create(String firstName, String lastName, String email){
            Customer customers = new Customer.Builder(lastName)
                    .firstName(firstName)
                    .email(email)
                    .build();
            return customers ;
        }
    }
