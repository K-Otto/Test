package discuss.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by student on 2015/06/03.
 */
@Entity
public class SiteManager implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String email;
    private String firstname;
    private String lastname;
    private String password;
    @Embedded
    private Contact contacts;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="siteManager_id")
    private List<Site> sites;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="siteManager_id_id")
    private List<Role> roles;

    private  SiteManager() {
    }

    public SiteManager(Builder builder) {
        id=builder.id;
        email=builder.email;
        firstname=builder.firstname;
        lastname=builder.lastname;
        password=builder.password;
    }

    public static class Builder{
        private Long id;
        private String email;
        private String firstname;
        private String lastname;
        private String password;
        private Contact contacts;
        private List<Site> sites;
        private List<Role> roles;

        public Builder(String email) {
            this.email = email;
        }

        public Builder id(Long value){
            this.id = value;
            return this;
        }
        public Builder firstname(String firstname){
            this.firstname=firstname;
            return this;
        }
        public Builder lastname(String lastname){
            this.lastname=lastname;
            return this;
        }
        public Builder password(String password){
            this.password=password;
            return this;
        }
        public Builder contacts(Contact value){
            this.contacts=value;
            return this;
        }
        public Builder sites(List<Site> value){
            this.sites=value;
            return this;
        }
        public Builder roles(List<Role> value){
            this.roles=value;
            return this;
        }

        public Builder copy(SiteManager value){
            this.id = value.id;
            this.email=value.email;
            this.firstname=value.firstname;
            this.lastname=value.lastname;
            this.password=value.password;
            this.contacts=value.contacts;
            this.sites=value.sites;
            this.roles=value.roles;
            return this;
        }

        public SiteManager build(){
            return new SiteManager(this);
        }
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstname() {
        return firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public String getPassword() {
        return password;
    }
    public Contact getContact() {
        return contacts;
    }
    public List<Site> getSite() {
        return sites;
    }

    public List<Role> getRole() {
        return roles;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SiteManager siteManager = (SiteManager) o;

        return id.equals(siteManager.id);

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
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
