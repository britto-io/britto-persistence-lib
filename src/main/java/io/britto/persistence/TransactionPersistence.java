package io.britto.persistence;

import io.britto.dto.Key;
import io.britto.dto.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * Created by tfulton on 7/3/16.
 */
public class TransactionPersistence
    implements Persistence<Key, Transaction>{

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public Transaction save(Key key, Transaction data) {
        return null;
    }

    @Override
    public Transaction read(Key key) {
        return null;
    }

    @Override
    public Transaction update(Key key, Transaction data) {
        return null;
    }

    @Override
    public void delete(Key key) {

    }
}
