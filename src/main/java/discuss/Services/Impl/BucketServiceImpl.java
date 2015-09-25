package discuss.Services.Impl;

import discuss.Services.BucketService;
import discuss.conf.factories.BucketFactory;
import discuss.domain.Bucket;
import discuss.domain.Harvest;
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
                              double weight,
                              Harvest harvests) {
        Bucket buckets =  BucketFactory
                .create(weight, harvests);

        return repository.save(buckets).toString();

    }

    @Override
    public Bucket getBucket (Long id) {

        return repository.findOne(id);
    }
}