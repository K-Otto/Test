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
    private Long id;

    private String subLocationName;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private List<Location> locations;


    private SubLocation() {
    }

    public SubLocation(Builder builder) {
        id = builder.id;
        subLocationName = builder.subLocationName;

    }

    public static class Builder {
        private Long id;
        private String subLocationName;
        private List<Location> locations;


        public Builder(String subLocationName) {
            this.subLocationName = subLocationName;
        }

        public Builder id(Long value) {
            this.id = value;
            return this;
        }

        public Builder locations(List<Location> value) {
            this.locations = value;
            return this;
        }

        public Builder copy(SubLocation value) {
            this.id = value.id;
            this.subLocationName = value.subLocationName;
            this.locations = value.locations;
            return this;
        }

        public SubLocation build() {
            return new SubLocation(this);
        }
    }

    public Long getId() {
        return id;
    }

    public String getSubLocationName() {
        return subLocationName;
    }

    public List<Location> getLocation() {
        return locations;
    }
}



