package discuss.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
/**
 * Created by student on 2015/09/13.
 */
@Entity
public class Hive implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long hiveID;

    private String hiveState ;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="subLocID")
    private SubLocation subLocations;



    private  Hive  () {
    }

    public Hive(Builder builder) {
        hiveID=builder.hiveID;
        hiveState=builder.hiveState ;
        subLocations=builder.subLocations;
    }
    public static class Builder{
        private Long hiveID;
        private String hiveState ;
        private SubLocation subLocations;


        public Builder(String hiveState ) {
            this.hiveState = hiveState ;
        }

        public Builder id(Long value){
            this.hiveID = value;
            return this;
        }

        public Builder subLocations(SubLocation value){
            this.subLocations=value;
            return this;
        }

        public Builder copy(Hive  value){
            this.hiveID = value.hiveID;
            this.hiveState =value.hiveState ;
            this.subLocations=value.subLocations;
            return this;
        }
        public Hive  build(){
            return new Hive  (this);
        }
    }
    public Long getId() {
        return hiveID;
    }

    public String getHiveState() {
        return hiveState;
    }
        public SubLocation getSubLocation() {
            return subLocations;
        }

    }