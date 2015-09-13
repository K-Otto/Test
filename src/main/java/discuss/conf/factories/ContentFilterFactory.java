package discuss.conf.factories;

import discuss.domain.ContentFilter;

/**
 * Created by student on 2015/06/03.
 */
public class ContentFilterFactory {
    public static ContentFilter create(String name){
        ContentFilter role = new ContentFilter.Builder(name)
                .build();
        return role;
    }
}