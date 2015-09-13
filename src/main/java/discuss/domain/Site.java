package discuss.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by student on 2015/06/03.
 */
@Entity
public class Site implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String url;
    private String storyurl;

    private  Site() {
    }

    public Site(Builder builder) {
        id=builder.id;
        name=builder.name;
        url=builder.url;
        storyurl=builder.storyurl;
    }

    public static class Builder{
        private Long id;
        private String name;
        private String url;
        private String storyurl;

        public Builder(String name) {
            this.name = name;
        }

        public Builder id(Long value){
            this.id = value;
            return this;
        }
        public Builder url(String url){
            this.url=url;
            return this;
        }
        public Builder storyurl(String storyurl){
            this.storyurl=storyurl;
            return this;
        }

        public Builder copy(Site value){
            this.id = value.id;
            this.name=value.name;
            this.url=value.url;
            this.storyurl=value.storyurl;
            return this;
        }

        public Site build(){
            return new Site(this);
        }
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }
    public String getStoryurl() {
        return storyurl;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Site site = (Site) o;

        return id.equals(site.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Reputation{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", storyurl='" + storyurl + '\'' +
                '}';
    }
}

