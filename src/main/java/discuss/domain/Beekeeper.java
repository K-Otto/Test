package discuss.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by student on 2015/09/13.
 */
@Entity
public class Beekeeper implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long beeID;

    private String firstName;
    private String lastName;
    private String email;


    private Beekeeper() {
    }

    public Long getId() {
        return beeID;
    }
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public Beekeeper(Builder builder){
        beeID=builder.beeID;
        firstName=builder.firstName;
        lastName=builder.lastName;
        email=builder.email;
    }

    public static class Builder{
        private String firstName;
        private String lastName;
        private String email;
        private long beeID;
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
        public Builder copy(Beekeeper value){
            this.beeID = value.beeID;
            this.lastName =value.lastName ;
            this.firstName=value.firstName;
            this.email=value.email;
            return this;
        }

        public Beekeeper build(){
            return new Beekeeper(this);
        }
    }
}
