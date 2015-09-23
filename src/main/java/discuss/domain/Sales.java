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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long salesID;
    private String SalesDate;
    private Double price;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bucketID")
    private Bucket buckets;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "custID")
    private Customer customers;


    private Sales() {
    }

    public Sales(Builder builder) {
        salesID = builder.salesID;
        price=builder.price;
        SalesDate = builder.SalesDate;
        customers = builder.customers;
        buckets=builder.buckets;
    }

    public static class Builder {
        private Long salesID;
        private String SalesDate;
        private Double price;
        private Customer customers;
        private Bucket buckets;


        public Builder(String SalesDate) {
            this.SalesDate = SalesDate;
        }

        public Builder id(Long value) {
            this.salesID = value;
            return this;
        }

        public Builder price(Double value) {
            this.price = value;
            return this;
        }

        public Builder customers(Customer value) {
            this.customers = value;
            return this;
        }

        public Builder buckets(Bucket value) {
            this.buckets = value;
            return this;
        }

        public Builder copy(Sales value) {
            this.salesID = value.salesID;
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
        return salesID;
    }

    public String getSalesDate() {
        return SalesDate;
    }

    public Double getPrice() {
        return price;
    }

    public Customer getCustomers() {
        return customers;
    }

    public Bucket getBuckets() {
        return buckets;
    }
}
