package discuss.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 * Created by student on 2015/09/13.
 */
@Entity
public class Location implements Serializable {
    @Id
    private Long id‭;

    private String locationName‭;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private List<Beekeeper> beekeepers;


    private Location() {
    }




    public Location (Builder‭ builder)
    {
        locationName‭=builder.locationName‭;
        id‭=builder.id‭;
    }

    public static class Builder‭{
        private Long id‭;
        private String locationName‭;
        private List<Beekeeper> beekeepers;


        public Builder‭(String locationName‭) {
            this.locationName‭= locationName‭;
        }

        public Builder‭ ID(Long value‭){
            this.id‭ = value‭;
            return this;
        }

        public Builder‭ beekeepers(List<Beekeeper> value){
            this.beekeepers=value;
            return this;
        }

        public Builder‭ copy(Location value){

            this.locationName‭=value.locationName‭;
            this.beekeepers=value.beekeepers;
            return this;
        }
        public Location build(){
            return new Location (this);
        }
    }
    public Long getId‭() {
        return id‭;
    }
    public String getLocationName‭‭() {
        return locationName‭;
    }

        public List<Beekeeper> getBeekeepers(){
        return beekeepers;
    }
        }

