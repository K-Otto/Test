package discuss.conf.factories;

import discuss.domain.*;

import java.util.Date;
import java.util.List;

/**
 * Created by student on 2015/06/03.
 */
public class CommentFactory {
    public static Comment create(String comments, Date date, String ipaddress, ContentFilter contentfilter,List<User> users, List<VoteUp> voteups,List<VoteDown> votedowns, List<Response> responses,List<Site> sites,List<AbuseReport> abusereports){
        Comment comment = new Comment.Builder(comments)
                .date(date)
                .ipaddress(ipaddress)
                .contentfilter(contentfilter)
                .users(users)
                .votedowns(votedowns)
                .voteups(voteups)
                .responses(responses)
                .sites(sites)
                .abusereports(abusereports)
                .build();
        return comment;
    }
}
