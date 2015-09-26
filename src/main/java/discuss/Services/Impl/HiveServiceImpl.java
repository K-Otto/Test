package discuss.Services.Impl;

import discuss.Services.HiveService;
import discuss.conf.factories.BeekeeperFactory;
import discuss.conf.factories.HiveFactory;
import discuss.conf.factories.LocationFactory;
import discuss.conf.factories.SubLocationFactory;
import discuss.domain.Beekeeper;
import discuss.domain.Hive;
import discuss.domain.Location;
import discuss.domain.SubLocation;
import discuss.respository.HiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by student on 2015/09/25.
 */
@Service
public class HiveServiceImpl implements HiveService{
    @Autowired
    HiveRepository repository;


    @Override
    public String saveHive(String hiveState,
                           String subLocationName,
                           String locationName,
                           String firstname,
                           String lastname,
                           String email) {
        Beekeeper beekeepers = BeekeeperFactory
                .create(firstname, lastname, email);

        Location locations = LocationFactory
                .create(locationName, beekeepers);
        SubLocation subLocations = SubLocationFactory
                .create(subLocationName, locations);
        Hive hives = HiveFactory
                .create(hiveState, subLocations);

        return repository.save(hives).toString();

    }

    @Override
    public Hive getHive (Long id) {

        return repository.findOne(id);
    }
}