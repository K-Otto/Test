package discuss.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Created by student on 2015/09/13.
 */
@Entity
public class Customer  implements Serializable {
    @Id
    private Long id;

    private String firstName;
    private String lastName;
    private String email;


    private Customer () {
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAge() {
        return email;
    }

    public Customer (Builder builder){
        firstName=builder.firstName;
        lastName=builder.lastName;
        email=builder.email;
    }

    public static class Builder{
        private String firstName;
        private String lastName;
        private String email;

        public Builder(String lastName) {
            this.lastName = lastName;
        }

        public Builder firstName(String value){
            this.firstName=value;
            return this;
        }

        public Builder email(String value){
            this.email=value;
            return this;

        }
        public Builder copy(Customer value){
            this.lastName =value.lastName ;
            this.firstName=value.firstName;
            this.email=value.email;
            return this;
        }

        public Customer  build(){
            return new Customer (this);
        }
    }
}
