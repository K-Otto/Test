package discuss.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by student on 2015/06/03.
 */
@Embeddable
public class Contact implements Serializable {

    private Long id;
    private String cellphone;
    private String address;
    private String postalcode;



        private Contact() {
        }

        public Contact(Builder builder) {
            cellphone=builder.cellphone;
            address=builder.address;
            postalcode=builder.postalcode;
        }

    public String getCellphone() {
        return cellphone;
    }

    public String getAddress() {
        return address;
    }
    public String getPostalcode() {
        return postalcode;
    }

    public static class Builder{
        private String cellphone;
        private String address;
        private String postalcode;

        public Builder(String cellphone) {
            this.cellphone = cellphone;
        }

        public Builder address(String address){
            this.address=address;
            return this;
        }
        public Builder postalcode(String postalcode){
            this.postalcode=postalcode;
            return this;
        }

        public Builder copy(Contact value){
            this.cellphone=value.cellphone;
            this.address=value.address;
            this.postalcode=value.postalcode;
            return this;
        }

        public Contact build(){
            return new Contact(this);
        }
    }

}