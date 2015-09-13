package discuss.conf.factories;

import discuss.domain.Site;

/**
 * Created by student on 2015/06/03.
 */
public class SiteFactory {
    public static Site create(String name, String url, String storyurl){
        Site site = new Site.Builder(name)
                .url(url)
                .storyurl(storyurl)
                .build();
        return site;
    }
}