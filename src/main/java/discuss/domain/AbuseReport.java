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
public class AbuseReport implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String contentCheck;
    

    private  AbuseReport() {
    }

    public AbuseReport(Builder builder) {
        id=builder.id;
        contentCheck=builder.contentCheck;
        
    }

    public static class Builder{
        private Long id;
        private String contentCheck;
        

        public Builder(String contentCheck) {
            this.contentCheck = contentCheck;
        }

        public Builder id(Long value){
            this.id = value;
            return this;
        }
        

        public Builder copy(AbuseReport value){
            this.id = value.id;
           
            this.contentCheck=value.contentCheck;
            return this;
        }

        public AbuseReport build(){
            return new AbuseReport(this);
        }
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return contentCheck;
    }

    

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbuseReport abuseReport = (AbuseReport) o;

        return id.equals(abuseReport.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "AbuseReport{" +
                "id=" + id +
                ", contentCheck='" + contentCheck + '\'' +
                
                '}';
    }
}
