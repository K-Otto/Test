package discuss.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by student on 2015/06/03.
 */
@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String email;
    private String screenName;
    private String password;
    private String status;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    private List<Reputation> reputations;

    private  User() {
    }

    public User(Builder builder) {
        id=builder.id;
        email=builder.email;
        screenName=builder.screenName;
        password=builder.password;
        status=builder.status;
    }

    public static class Builder{
        private Long id;
        private String email;
        private String screenName;
        private String password;
        private String status;
        private List<Reputation> reputations;

        public Builder(String email) {
            this.email = email;
        }

        public Builder id(Long value){
            this.id = value;
            return this;
        }
        public Builder screenName(String screenName){
            this.screenName=screenName;
            return this;
        }
        public Builder password(String password){
            this.password=password;
            return this;
        }
        public Builder status(String status){
            this.status=status;
            return this;
        }
        public Builder reputations(List<Reputation> value){
            this.reputations=value;
            return this;
        }

        public Builder copy(User value){
            this.id = value.id;
            this.email=value.email;
            this.screenName=value.screenName;
            this.password=value.password;
            this.status=value.status;
            return this;
        }

        public User build(){
            return new User(this);
        }
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getScreenName() {
        return screenName;
    }
    public String getPassword() {
        return password;
    }
    public String getStatus() {
        return status;
    }
    public List<Reputation> getReputation() {
        return reputations;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return id.equals(user.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Reputation{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", screenName='" + screenName + '\'' +
                ", password='" + password + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
