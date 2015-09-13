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
    private Long id;

    private Double weight;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private List<Harvest> harvests;


    private Bucket() {
    }

    public Bucket(Builder builder) {
        id = builder.id;
        weight = builder.weight;

    }

    public static class Builder {
        private Long id;
        private Double weight;
        private List<Harvest> harvests;


        public Builder(Double weight) {
            this.weight = weight;
        }

        public Builder id(Long value) {
            this.id = value;
            return this;
        }

        public Builder harvests(List<Harvest> value) {
            this.harvests = value;
            return this;
        }

        public Builder copy(Bucket value) {
            this.id = value.id;
            this.weight = value.weight;
            this.harvests = value.harvests;
            return this;
        }

        public Bucket build() {
            return new Bucket(this);
        }
    }

    public Long getId() {
        return id;
    }

    public Double getWeight() {
        return weight;
    }

    public List<Harvest> getHarvests() {
        return harvests;
    }
}
