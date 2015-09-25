package discuss.Services.Impl;

import discuss.Services.LocationService;
import discuss.conf.factories.LocationFactory;
import discuss.domain.Beekeeper;
import discuss.domain.Location;
import discuss.respository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by student on 2015/09/25.
 */
@Service
public class LocationServiceImpl implements LocationService {
    @Autowired
    LocationRepository repository;


    @Override
    public String saveLocation(String locationName,
                                Beekeeper beekeeper) {
        Location locations = LocationFactory
                .create(locationName, beekeeper);

        return repository.save(locations).toString();

    }

    @Override
    public Location geLocation (Long id) {

        return repository.findOne(id);
    }
}