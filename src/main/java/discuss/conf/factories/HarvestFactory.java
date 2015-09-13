package discuss.conf.factories;

import discuss.domain.Harvest;
import discuss.domain.SubLocation;

import java.util.List;

/**
 * Created by student on 2015/09/13.
 */
public class HarvestFactory {
    public static Harvest create(String harvestDate,Double weight, List<SubLocation> subLocations){
        Harvest harvests= new Harvest.Builder(harvestDate)
                .weight(weight)
                .subLocations(subLocations)
                .build();
        return harvests;
    }
}
