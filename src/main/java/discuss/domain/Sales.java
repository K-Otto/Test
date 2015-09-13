package discuss.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 * Created by student on 2015/09/13.
 */
@Entity
public class Sales implements Serializable {
    @Id
    private Long id;

    private String SalesDate;
    private Double price;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private List<Bucket> buckets;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private List<Customer> customers;


    private Sales() {
    }

    public Sales(Builder builder) {
        id = builder.id;
        SalesDate = builder.SalesDate;

    }

    public static class Builder {
        private Long id;
        private String SalesDate;
        private Double price;
        private List<Customer> customers;
        private List<Bucket> buckets;


        public Builder(String SalesDate) {
            this.SalesDate = SalesDate;
        }

        public Builder id(Long value) {
            this.id = value;
            return this;
        }

        public Builder price(Double value) {
            this.price = value;
            return this;
        }

        public Builder customers(List<Customer> value) {
            this.customers = value;
            return this;
        }

        public Builder buckets(List<Bucket> value) {
            this.buckets = value;
            return this;
        }

        public Builder copy(Sales value) {
            this.id = value.id;
            this.SalesDate = value.SalesDate;
            this.price = value.price;

            this.customers = value.customers;
            this.buckets = value.buckets;
            return this;
        }

        public Sales build() {
            return new Sales(this);
        }
    }

    public Long getId() {
        return id;
    }

    public String getSalesDate() {
        return SalesDate;
    }

    public Double getPrice() {
        return price;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public List<Bucket> getBuckets() {
        return buckets;
    }
}
