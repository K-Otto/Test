package discuss.conf.factories;

import discuss.domain.Hive;
import discuss.domain.Super;

import java.util.List;

/**
 * Created by student on 2015/09/13.
 */
public class SuperFactory {
    public static Super create(String state, List<Hive> hives){
        Super supers= new Super.Builder(state)
                .hives(hives)
                .build();
        return supers;
    }
}
