package discuss.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by hashcode on 2015/06/02.
 */
@Entity
public class Role implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;

    private  Role() {
    }

    public Role(Builder builder) {
        id=builder.id;
        name=builder.name;
        description=builder.description;
    }

    public static class Builder{
        private Long id;
        private String name;
        private String description;

        public Builder(String name) {
            this.name = name;
        }

        public Builder id(Long value){
            this.id = value;
            return this;
        }
        public Builder description(String value){
            this.description=value;
            return this;
        }

        public Builder copy(Role value){
            this.id = value.id;
            this.description=value.description;
            this.name=value.name;
            return this;
        }

        public Role build(){
            return new Role(this);
        }
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role = (Role) o;

        return id.equals(role.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
