package discuss.Services.Impl;

import discuss.Services.HarvestService;
import discuss.conf.factories.HarvestFactory;
import discuss.domain.Harvest;
import discuss.domain.SubLocation;
import discuss.respository.HarvestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by student on 2015/09/25.
 */
@Service
public class HarvestServiceImpl implements HarvestService {
    @Autowired
    HarvestRepository repository;


    @Override
    public String saveHarvest(String harvestDate,
                              double weight,
                              SubLocation subLocations) {
        Harvest harvests =  HarvestFactory
                .create(harvestDate, weight, subLocations);

        return repository.save(harvests).toString();

    }

    @Override
    public Harvest getHarvest (Long id) {

        return repository.findOne(id);
    }
}