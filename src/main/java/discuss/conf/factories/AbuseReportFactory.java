package discuss.conf.factories;

import discuss.domain.AbuseReport;

/**
 * Created by student on 2015/06/03.
 */
public class AbuseReportFactory {
    public static AbuseReport create(String name){
        AbuseReport role = new AbuseReport.Builder(name)
                .build();
        return role;
    }
}