package discuss.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by student on 2015/06/03.
 */
@Entity
public class Response implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String comment;
    private Date date;
    private String ipaddress;
    @Embedded
    private ContentFilter contentfilter;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    private List<User> users;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    private List<VoteDown> votedowns;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    private List<VoteUp> voteups;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    private List<AbuseReport> abusereports;


    private  Response() {
    }

    public Response(Builder builder) {
        id=builder.id;
        comment=builder.comment;
        date=builder.date;
        ipaddress=builder.ipaddress;


    }

    public static class Builder{
        private Long id;
        private String comment;
        private Date date;
        private String ipaddress;
        private ContentFilter contentfilter;
        private List<User> users;
        private List<VoteUp> voteups;
        private List<VoteDown> votedowns;
        private List<AbuseReport> abusereports;

        public Builder(String comment) {
            this.comment = comment;
        }

        public Builder id(Long value){
            this.id = value;
            return this;
        }
        public Builder date(Date date){
            this.date=date;
            return this;
        }
        public Builder ipaddress(String ipaddress){
            this.ipaddress=ipaddress;
            return this;
        }
        public Builder contentfilter(ContentFilter value){
            this.contentfilter=value;
            return this;
        }
        public Builder voteups(List<VoteUp> value){
            this.voteups=value;
            return this;
        }
        public Builder votedowns(List<VoteDown> value){
            this.votedowns=value;
            return this;
        }
        public Builder users(List<User> value){
            this.users=value;
            return this;
        }
        public Builder abusereports(List<AbuseReport> value){
            this.abusereports=value;
            return this;
        }

        public Builder copy(Response value){
            this.id = value.id;
            this.comment=value.comment;
            this.date=value.date;
            this.ipaddress=value.ipaddress;
            this.contentfilter=value.contentfilter;
            this.users=value.users;
            this.voteups=value.voteups;
            this.votedowns=value.votedowns;
            this.abusereports=value.abusereports;
            return this;
        }

        public Response build(){
            return new Response(this);
        }
    }

    public Long getId() {
        return id;
    }

    public String getComment() {
        return comment;
    }

    public Date getDate() {
        return date;
    }
    public String getIpaddress() {
        return ipaddress;
    }
    public ContentFilter getContentfilter() {
        return contentfilter;
    }
    public List<VoteUp> getVoteUp() {
        return voteups;
    }
    public List<VoteDown> getVoteDown() {
        return votedowns;
    }
    public List<User> getUser() {
        return users;
    }
    public List<AbuseReport> getAbuseReport() {
        return abusereports;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Response comments = (Response) o;

        return id.equals(comments.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Reputation{" +
                "id=" + id +
                ", Response='" + comment + '\'' +
                ", date='" + date + '\'' +
                ", ipaddress='" + ipaddress + '\'' +
                '}';
    }
}

