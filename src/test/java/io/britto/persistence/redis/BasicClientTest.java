package io.britto.persistence.redis;

import com.google.inject.*;
import com.google.inject.name.Named;
import org.junit.*;
import redis.clients.jedis.*;
import redis.clients.jedis.exceptions.JedisConnectionException;

/**
 * Created by tfulton on 6/29/16.
 */
public class BasicClientTest {

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
    }

    @Inject
    JedisPool jedisPool;

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

        Jedis redis = null;
        try
        {
            redis = jedisPool.getResource();
        }
        catch (JedisConnectionException e)
        {
            if (redis != null)
            {
                jedisPool.close();
                redis = null;
            }
            throw e;
        }
        finally
        {
            if (redis != null)
            {
                jedisPool.close();
            }
        }
    }
}
