package io.britto.persistence;

import io.britto.dto.Transaction;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

/**
 * Created by tfulton on 7/4/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/britto-persistence-test.xml")
public class TransactionPersistenceTest {

    @Autowired
    private TransactionPersistence transactionPersistence;

    @Autowired
    private JedisConnectionFactory jedisConnectionFactory;

    @Test
    public void saveTransaction() {
        Transaction transaction = new Transaction();
        transaction.setMerchantId(UUID.randomUUID().toString());
        transaction.setMerchantTransactionReferenceId(UUID.randomUUID().toString());
        transactionPersistence.save(transaction.getKey(), transaction);

        Transaction readTransaction = transactionPersistence.read(transaction.getKey());
        Assert.assertEquals(transaction, readTransaction);
    }

    @Test
    public void testDeleteTransaction() {
        Transaction transaction = new Transaction();
        transaction.setMerchantId(UUID.randomUUID().toString());
        transaction.setMerchantTransactionReferenceId(UUID.randomUUID().toString());
        transactionPersistence.save(transaction.getKey(), transaction);

        Transaction readTransaction = transactionPersistence.read(transaction.getKey());
        Assert.assertEquals(transaction, readTransaction);

        transactionPersistence.delete(transaction.getKey());
        Assert.assertNull(transactionPersistence.read(transaction.getKey()));
    }
}
