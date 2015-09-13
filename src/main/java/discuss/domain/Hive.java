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
    private Long id;

    private String hiveState ;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    private List<SubLocation> subLocations;



    private  Hive  () {
    }

    public Hive(Builder builder) {
        id=builder.id;
        hiveState=builder.hiveState ;

    }
    public static class Builder{
        private Long id;
        private String hiveState ;
        private List<SubLocation> subLocations;


        public Builder(String hiveState ) {
            this.hiveState = hiveState ;
        }

        public Builder id(Long value){
            this.id = value;
            return this;
        }

        public Builder subLocations(List<SubLocation> value){
            this.subLocations=value;
            return this;
        }

        public Builder copy(Hive  value){
            this.id = value.id;
            this.hiveState =value.hiveState ;
            this.subLocations=value.subLocations;
            return this;
        }
        public Hive  build(){
            return new Hive  (this);
        }
    }
    public Long getId() {
        return id;
    }

    public String getHiveState() {
        return hiveState;
    }
        public List<SubLocation> getSubLocation() {
            return subLocations;
        }

    }