package discuss.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
/**
 * Created by student on 2015/09/13.
 */
@Entity
public class Bucket implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bucketID;

    private Double weight;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "harvestID")
    private Harvest harvests;


    private Bucket() {
    }

    public Bucket(Builder builder) {
        bucketID = builder.bucketID;
        weight = builder.weight;

    }

    public static class Builder {
        private Long bucketID;
        private Double weight;
        private Harvest harvests;


        public Builder(Double weight) {
            this.weight = weight;
        }

        public Builder id(Long value) {
            this.bucketID = value;
            return this;
        }

        public Builder harvests(Harvest value) {
            this.harvests = value;
            return this;
        }

        public Builder copy(Bucket value) {
            this.bucketID = value.bucketID;
            this.weight = value.weight;
            this.harvests = value.harvests;
            return this;
        }

        public Bucket build() {
            return new Bucket(this);
        }
    }

    public Long getId() {
        return bucketID;
    }

    public Double getWeight() {
        return weight;
    }

    public Harvest getHarvests() {
        return harvests;
    }
}
