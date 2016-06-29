package io.britto.persistence.redis;

import org.junit.*;
import redis.clients.jedis.Connection;
import redis.clients.jedis.Jedis;

/**
 * Created by tfulton on 6/29/16.
 */
public class BasicClientTest {

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
    public void testJedisConnect() {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        System.out.println("Connected to Redis");
        jedis.connect();
        Assert.assertTrue(jedis.getClient().isConnected());
        jedis.disconnect();
    }
}
