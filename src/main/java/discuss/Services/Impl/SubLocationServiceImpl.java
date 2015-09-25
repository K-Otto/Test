package discuss.Services.Impl;

import discuss.Services.SubLocationService;
import discuss.conf.factories.SubLocationFactory;
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
                               Location locations) {
        SubLocation subLocations = SubLocationFactory
                .create(subLocationName, locations);

        return repository.save(subLocations).toString();

    }

    @Override
    public SubLocation getSubLocation (Long id) {

        return repository.findOne(id);
    }
}
