package discuss.Services.Impl;

import discuss.Services.SuperService;
import discuss.conf.factories.SuperFactory;
import discuss.domain.Hive;
import discuss.domain.Super;
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
                               Hive hives) {
        Super supers = SuperFactory
                .create(superState, hives);

        return repository.save(supers).toString();

    }

    @Override
    public Super getSuper (Long id) {

        return repository.findOne(id);
    }
}