package io.britto.config;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.name.Named;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Protocol;

/**
 * Created by todd on 6/29/16.
 */
public class RedisModule extends AbstractModule {

    @Override
    protected void configure() {
    }

    @Provides
    @Named("jedisPool")
    JedisPool provideJedisPool() {
        return new JedisPool(
                new JedisPoolConfig(),
                "localhost",
                6379,
                Protocol.DEFAULT_TIMEOUT, "");
    }
}
