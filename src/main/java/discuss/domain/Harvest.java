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
    private Long id;

    private String harvestDate ;
    private Double weight;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    private List<SubLocation > subLocations;



    private  Harvest  () {
    }

    public Harvest(Builder builder) {
        id=builder.id;
        harvestDate=builder.harvestDate  ;
        weight=builder.weight;
    }
    public static class Builder{
        private Long id;
        private String harvestDate  ;
        private Double weight;
        private List<SubLocation > subLocations;


        public Builder(String harvestDate  ) {
            this.harvestDate  = harvestDate  ;
        }

        public Builder id(Long value){
            this.id = value;
            return this;
        }
        public Builder weight(Double value){
            this.weight = value;
            return this;
        }

        public Builder subLocations(List<SubLocation > value){
            this.subLocations=value;
            return this;
        }

        public Builder copy(Harvest  value){
            this.id = value.id;
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
        return id;
    }

    public String getHarvestDate () {
        return harvestDate;
    }

    public Double getWeight() {
        return weight;
    }

    public List<SubLocation> getSubLocation() {
        return subLocations;
    }
}

