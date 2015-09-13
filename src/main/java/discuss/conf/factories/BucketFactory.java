package discuss.conf.factories;

import discuss.domain.Bucket;
import discuss.domain.Harvest;

import java.util.List;

/**
 * Created by student on 2015/09/13.
 */
public class BucketFactory {
    public static Bucket create(Double weight, List<Harvest> harvests){
        Bucket buckets= new Bucket.Builder(weight)
                .harvests(harvests)
                .build();
        return buckets;
    }
}
