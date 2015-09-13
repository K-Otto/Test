package discuss.conf.factories;

import discuss.domain.Contact;

/**
 * Created by student on 2015/06/03.
 */
public class ContactFactory {
    public static Contact create(String email, String address, String postalcode){
        Contact contact = new Contact.Builder(email)
                .address(address)
                .postalcode(postalcode)
                .build();
        return contact;
    }
}