package io.britto.persistence.redis;

import com.google.inject.*;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.*;
import redis.clients.jedis.exceptions.JedisConnectionException;

import java.util.UUID;

/**
 * Created by tfulton on 6/29/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/britto-persistence-test-context.xml")
public class BasicClientTest {

    @Autowired
    JedisConnectionFactory jedisConnectionFactory;

    @Autowired
    private StringRedisTemplate redisTemplate;

    protected Injector injector = Guice.createInjector(new AbstractModule() {
        @Override
        protected void configure() {
        }

        @Provides
        JedisPool provideJedisPool() {
            return new JedisPool("localhost");
        }
    });

    @Before
    public void setup () {
        injector.injectMembers(this);

        jedis = jedisPool.getResource();
    }

    @After
    public void tearDown() {
        if (jedis != null) {
            jedis.close();
        }
    }

    @Inject
    JedisPool jedisPool;

    private Jedis jedis;

    @Ignore
    @Test
    public void testGoodConnect() {
        class TestConnection extends Connection {
            public TestConnection() {
                super("127.0.0.1", 6379);
            }
        }

        TestConnection client = new TestConnection();
        Assert.assertTrue(client.isConnected());
    }

    @Test
    public void testJedisBasicConnectionTest() {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        System.out.println("Connected to Redis");
        jedis.connect();
        Assert.assertTrue(jedis.getClient().isConnected());
        jedis.disconnect();
    }

    @Test
    public void testJedisPoolBasicPoolTest() {
        Jedis jedis = null;
        try
        {
            jedis = jedisPool.getResource();
            Assert.assertTrue(jedis.isConnected());
        }
        catch (JedisConnectionException e)
        {
            if (jedis != null)
            {
                jedisPool.close();
                jedis = null;
            }
            throw e;
        }
        finally
        {
            if (jedis != null)
            {
                jedisPool.close();
            }
        }
    }

    @Test
    public void testBasicReadWrite() {
        Long start = System.currentTimeMillis();
        System.out.println("Begin time: " + start);

        int iterations = 1000;
        for (int i=0; i < iterations; i++) {
            String randomKey = UUID.randomUUID().toString();
            String randomValue = UUID.randomUUID().toString();
            jedis.set(randomKey, randomValue);

            Assert.assertEquals(randomValue, jedis.get(randomKey));
        }
        Long end = System.currentTimeMillis();
        System.out.println("End time: " + end);
        Long diff = end - start;
        System.out.println("Diff: " + diff);
        double perOperation = diff/iterations;
        System.out.println("Per: " + perOperation);
    }

    @Test
    public void testSpringDataConnection() {

        RedisConnection redisConnection = jedisConnectionFactory.getConnection();
        String pong = redisConnection.ping();
        Assert.assertEquals("PONG", pong);
        redisConnection.close();
    }

    @Test
    public void testSpringDataWrite() {

        String key = UUID.randomUUID().toString();
        String value = UUID.randomUUID().toString();

        RedisConnection redisConnection = jedisConnectionFactory.getConnection();
        redisConnection.set(key.getBytes(), value.getBytes());

        Assert.assertTrue(jedisConnectionFactory.getConnection().exists(key.getBytes()));
        Assert.assertEquals(value, new String(redisConnection.get(key.getBytes())));
    }

    @Test
    public void testStringRedisTemplate() {

        String key = UUID.randomUUID().toString();
        String value = UUID.randomUUID().toString();

        redisTemplate.opsForValue().set(key, value);

        Assert.assertTrue(redisTemplate.getConnectionFactory().getConnection().exists(key.getBytes()));
        Assert.assertEquals(value, redisTemplate.opsForValue().get(key));
    }
}
