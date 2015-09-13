package discuss.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 * Created by student on 2015/09/13.
 */
@Entity
public class Super implements Serializable {
    @Id
    private Long id;

    private String superState;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private List<Hive> hives;


    private Super() {
    }

    public Super(Builder builder) {
        id = builder.id;
        superState = builder.superState;

    }

    public static class Builder {
        private Long id;
        private String superState;
        private List<Hive> hives;


        public Builder(String superState) {
            this.superState = superState;
        }

        public Builder id(Long value) {
            this.id = value;
            return this;
        }

        public Builder hives(List<Hive> value) {
            this.hives = value;
            return this;
        }

        public Builder copy(Super value) {
            this.id = value.id;
            this.superState = value.superState;
            this.hives = value.hives;
            return this;
        }

        public Super build() {
            return new Super(this);
        }
    }

    public Long getId() {
        return id;
    }

    public String getSuperState() {
        return superState;
    }

    public List<Hive> getHives() {
        return hives;
    }
}


