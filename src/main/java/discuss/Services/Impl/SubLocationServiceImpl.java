package discuss.Services.Impl;

import discuss.Services.SubLocationService;
import discuss.conf.factories.BeekeeperFactory;
import discuss.conf.factories.LocationFactory;
import discuss.conf.factories.SubLocationFactory;
import discuss.domain.Beekeeper;
import discuss.domain.Location;
import discuss.domain.SubLocation;
import discuss.respository.SubLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by student on 2015/09/25.
 */
@Service
public class SubLocationServiceImpl implements SubLocationService{
    @Autowired
    SubLocationRepository repository;


    @Override
    public String saveSubLocation(String subLocationName,
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

        return repository.save(subLocations).toString();

    }

    @Override
    public SubLocation getSubLocation (Long id) {

        return repository.findOne(id);
    }
}
