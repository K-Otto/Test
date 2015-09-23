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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long superID;

    private String superState;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "hiveID")
    private Hive hives;


    private Super() {
    }

    public Super(Builder builder) {
        superID = builder.superID;
        superState = builder.superState;
        hives=builder.hives;
    }

    public static class Builder {
        private Long superID;
        private String superState;
        private Hive hives;


        public Builder(String superState) {
            this.superState = superState;
        }

        public Builder id(Long value) {
            this.superID = value;
            return this;
        }

        public Builder hives(Hive value) {
            this.hives = value;
            return this;
        }

        public Builder copy(Super value) {
            this.superID = value.superID;
            this.superState = value.superState;
            this.hives = value.hives;
            return this;
        }

        public Super build() {
            return new Super(this);
        }
    }

    public Long getId() {
        return superID;
    }

    public String getSuperState() {
        return superState;
    }

    public Hive getHives() {
        return hives;
    }
}


