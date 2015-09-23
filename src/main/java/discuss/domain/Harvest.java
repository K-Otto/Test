package discuss.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 * Created by student on 2015/09/13.
 */
@Entity
public class Harvest implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long harvestID;

    private String harvestDate ;
    private Double weight;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="subLocID")
    private SubLocation  subLocations;



    private  Harvest  () {
    }

    public Harvest(Builder builder) {
        harvestID=builder.harvestID;
        harvestDate=builder.harvestDate  ;
        weight=builder.weight;
        subLocations=builder.subLocations;
    }
    public static class Builder{
        private Long harvestID;
        private String harvestDate  ;
        private Double weight;
        private SubLocation  subLocations;


        public Builder(String harvestDate  ) {
            this.harvestDate  = harvestDate  ;
        }

        public Builder id(Long value){
            this.harvestID = value;
            return this;
        }
        public Builder weight(Double value){
            this.weight = value;
            return this;
        }

        public Builder subLocations(SubLocation value){
            this.subLocations=value;
            return this;
        }

        public Builder copy(Harvest  value){
            this.harvestID = value.harvestID;
            this.harvestDate  =value.harvestDate  ;
            this.weight  =value.weight  ;
            this.subLocations=value.subLocations;
            return this;
        }
        public Harvest  build(){
            return new Harvest  (this);
        }
    }
    public Long getId() {
        return harvestID;
    }

    public String getHarvestDate () {
        return harvestDate;
    }

    public Double getWeight() {
        return weight;
    }

    public SubLocation getSubLocation() {
        return subLocations;
    }
}

