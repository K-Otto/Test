package discuss.Services.Impl;

import discuss.Services.HiveService;
import discuss.conf.factories.HiveFactory;
import discuss.domain.Hive;
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
                               SubLocation sublocations) {
        Hive hives = HiveFactory
                .create(hiveState, sublocations);

        return repository.save(hives).toString();

    }

    @Override
    public Hive getHive (Long id) {

        return repository.findOne(id);
    }
}