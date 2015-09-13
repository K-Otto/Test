package discuss.domain;



import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by student on 2015/06/03.
 */





@Entity
public class Comment implements Serializable {
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
    private List<Response> responses;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    private List<Site> sites;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    private List<AbuseReport> abusereports;

    private  Comment() {
    }

    public Comment(Builder builder) {
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
        private List<Response> responses;
        private List<Site> sites;
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
        public Builder users(List<User> value){
            this.users=value;
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
        public Builder responses(List<Response> value){
            this.responses=value;
            return this;
        }
        public Builder sites(List<Site> value){
            this.sites=value;
            return this;
        }
        public Builder abusereports(List<AbuseReport> value){
            this.abusereports=value;
            return this;
        }

        public Builder copy(Comment value){
            this.id = value.id;
            this.comment=value.comment;
            this.date=value.date;
            this.ipaddress=value.ipaddress;
            this.contentfilter=value.contentfilter;
            this.users=value.users;
            this.voteups=value.voteups;
            this.votedowns=value.votedowns;
            this.responses=value.responses;
            this.sites=value.sites;
            this.abusereports=value.abusereports;
            return this;
        }

        public Comment build(){
            return new Comment(this);
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
    public List<User> getUser() {
        return users;
    }
    public List<VoteUp> getVoteUp() {
        return voteups;
    }
    public List<VoteDown> getVoteDown() {
        return votedowns;
    }
    public List<Response> getResponse() {
        return responses;
    }
    public List<Site> getSite() {
        return sites;
    }
    public List<AbuseReport> getAbusereports() {
        return abusereports;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Comment comments = (Comment) o;

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
                ", Comment='" + comment + '\'' +
                ", date='" + date + '\'' +
                ", ipaddress='" + ipaddress + '\'' +
                '}';
    }
}
