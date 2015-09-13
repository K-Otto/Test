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
public class VoteDown implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int counter;


    private  VoteDown() {
    }

    public VoteDown(Builder builder) {
        id=builder.id;
        counter=builder.counter;

    }

    public static class Builder{
        private Long id;
        private int counter;


        public Builder(int counter) {
            this.counter = counter;
        }

        public Builder id(Long value){
            this.id = value;
            return this;
        }


        public Builder copy(VoteDown value){
            this.id = value.id;

            this.counter=value.counter;
            return this;
        }

        public VoteDown build(){
            return new VoteDown(this);
        }
    }

    public Long getId() {
        return id;
    }

    public int getCounter() {
        return counter;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VoteDown abuseReport = (VoteDown) o;

        return id.equals(abuseReport.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "VoteDown{" +
                "id=" + id +
                ", counter='" + counter + '\'' +

                '}';
    }
}
