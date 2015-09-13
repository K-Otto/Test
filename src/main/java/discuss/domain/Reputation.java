package discuss.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by student on 2015/06/03.
 */
@Entity
public class Reputation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date date;
    private int value;

    private  Reputation() {
    }

    public Reputation(Builder builder) {
        id=builder.id;
        date=builder.date;
        value=builder.value;
    }

    public static class Builder{
        private Long id;
        private Date date;
        private int value;

        public Builder(Date date) {
            this.date = date;
        }

        public Builder id(Long value){
            this.id = value;
            return this;
        }
        public Builder value(int value){
            this.value=value;
            return this;
        }

        public Builder copy(Reputation value){
            this.id = value.id;
            this.date=value.date;
            this.value=value.value;
            return this;
        }

        public Reputation build(){
            return new Reputation(this);
        }
    }

    public Long getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reputation reputation = (Reputation) o;

        return id.equals(reputation.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Reputation{" +
                "id=" + id +
                ", Date='" + date + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}