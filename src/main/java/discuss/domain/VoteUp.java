package discuss.domain;

import org.hibernate.annotations.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by student on 2015/06/03.
 */
@Entity
public class VoteUp implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int counter;


    private  VoteUp() {
    }

    public VoteUp(Builder builder) {
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


        public Builder copy(VoteUp value){
            this.id = value.id;

            this.counter=value.counter;
            return this;
        }

        public VoteUp build(){
            return new VoteUp(this);
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

        VoteUp abuseReport = (VoteUp) o;

        return id.equals(abuseReport.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "VoteUp{" +
                "id=" + id +
                ", counter='" + counter + '\'' +

                '}';
    }
}
