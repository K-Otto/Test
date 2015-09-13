package discuss.conf.factories;

import discuss.domain.*;

import java.util.Date;
import java.util.List;

/**
 * Created by student on 2015/06/03.
 */
public class ResponseFactory {
    public static Response create(String comment, Date date, String ipaddress, ContentFilter contentfilter,List<User> users, List<VoteUp> voteups,List<VoteDown> votedowns,List<AbuseReport> abusereports){
        Response response = new Response.Builder(comment)
                .date(date)
                .ipaddress(ipaddress)
                .contentfilter(contentfilter)
                .users(users)
                .voteups(voteups)
                .votedowns(votedowns)
                .abusereports(abusereports)
                .build();
        return response;
    }
}
