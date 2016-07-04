package io.britto.persistence;

import io.britto.dto.Key;
import io.britto.dto.Transaction;
import io.britto.dto.TransactionKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * Created by tfulton on 7/3/16.
 */
public class TransactionPersistence
    implements Persistence<TransactionKey, Transaction>{

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public Transaction save(TransactionKey key, Transaction data) {
        return null;
    }

    @Override
    public Transaction read(TransactionKey key) {
        return null;
    }

    @Override
    public Transaction update(TransactionKey key, Transaction data) {
        return null;
    }

    @Override
    public void delete(TransactionKey key) {

    }
}
