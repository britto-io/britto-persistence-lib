package io.britto.persistence;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.britto.dto.Transaction;
import io.britto.dto.TransactionKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import static com.google.common.base.Preconditions.*;

/**
 * Created by tfulton on 7/3/16.
 */
@Service("transactionPersistence")
public class TransactionPersistence
        implements Persistence<TransactionKey, Transaction> {

    @Autowired
    private StringRedisTemplate redisTemplate;

    protected Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Override
    public void save(TransactionKey key, Transaction data) {
        redisTemplate.opsForValue().set(key.getKey(), gson.toJson(data));
        checkArgument(redisTemplate.getConnectionFactory().getConnection().exists(key.getKey().getBytes()));
    }

    @Override
    public Transaction read(TransactionKey key) {
        String json = redisTemplate.opsForValue().get(key.getKey());
        if (json != null) {
            return gson.fromJson(json, Transaction.class);
        }
        return null;
    }

    @Override
    public void delete(TransactionKey key) {
        redisTemplate.getConnectionFactory()
                .getConnection().del(key.getKey().getBytes());

    }
}
