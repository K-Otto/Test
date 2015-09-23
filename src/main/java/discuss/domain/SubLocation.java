package discuss.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 * Created by student on 2015/09/13.
 */
@Entity
public class SubLocation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long subLocID;

    private String subLocationName;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "locID")
    private Location locations;


    private SubLocation() {
    }

    public SubLocation(Builder builder) {
        subLocID = builder.subLocID;
        subLocationName = builder.subLocationName;
        locations=builder.locations;
    }

    public static class Builder {
        private Long subLocID;
        private String subLocationName;
        private Location locations;


        public Builder(String subLocationName) {
            this.subLocationName = subLocationName;
        }

        public Builder id(Long value) {
            this.subLocID = value;
            return this;
        }

        public Builder locations(Location value) {
            this.locations = value;
            return this;
        }

        public Builder copy(SubLocation value) {
            this.subLocID = value.subLocID;
            this.subLocationName = value.subLocationName;
            this.locations = value.locations;
            return this;
        }

        public SubLocation build() {
            return new SubLocation(this);
        }
    }

    public Long getId() {
        return subLocID;
    }

    public String getSubLocationName() {
        return subLocationName;
    }

    public Location getLocation() {
        return locations;
    }
}



