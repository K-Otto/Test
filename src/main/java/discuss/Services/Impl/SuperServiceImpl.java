package discuss.Services.Impl;

import discuss.Services.SuperService;
import discuss.conf.factories.*;
import discuss.domain.*;
import discuss.respository.SuperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by student on 2015/09/25.
 */
@Service
public class SuperServiceImpl implements SuperService {
    @Autowired
    SuperRepository repository;


    @Override
    public String saveSuper(String superState,
                            String hiveState,
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
        Super supers = SuperFactory
                .create(superState, hives);

        return repository.save(supers).toString();

    }

    @Override
    public Super getSuper (Long id) {

        return repository.findOne(id);
    }
}