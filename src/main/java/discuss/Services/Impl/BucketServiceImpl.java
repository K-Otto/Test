package discuss.Services.Impl;

import discuss.Services.BucketService;
import discuss.conf.factories.*;
import discuss.domain.*;
import discuss.respository.BucketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by student on 2015/09/25.
 */
@Service
public class BucketServiceImpl implements BucketService {
    @Autowired
    BucketRepository repository;


    @Override
    public String saveBucket(
            double bucWeight,
            String harvestDate,
            double harWeight,
            String subLocationName,
            String locationName,
            String bFirstname,
            String bLastname,
            String bEmail) {
        Beekeeper beekeepers = BeekeeperFactory
                .create(bFirstname, bLastname, bEmail);

        Location locations = LocationFactory
                .create(locationName, beekeepers);
        SubLocation subLocations = SubLocationFactory
                .create(subLocationName, locations);
        Harvest harvests =  HarvestFactory
                .create(harvestDate, harWeight, subLocations);
        Bucket buckets =  BucketFactory
                .create(bucWeight, harvests);


        return repository.save(buckets).toString();

    }

    @Override
    public Bucket getBucket (Long id) {

        return repository.findOne(id);
    }
}