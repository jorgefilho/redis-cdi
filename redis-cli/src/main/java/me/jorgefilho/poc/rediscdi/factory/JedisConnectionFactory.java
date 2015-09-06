package me.jorgefilho.poc.rediscdi.factory;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.exceptions.JedisConnectionException;

@ApplicationScoped
public class JedisConnectionFactory {

	private static final Logger LOGGER = LoggerFactory.getLogger(JedisConnectionFactory.class);
	
	@Inject
    private JedisPool jedisPool;
 
    @Produces
    public Jedis getJedis(){
    	Jedis jedis = null;
    	try{
    		jedis = jedisPool.getResource();
    	} catch (JedisConnectionException ex) {
    		LOGGER.error("Problems trying to get the Redis connection.");
    	}
        return jedis;
    }

 
    public void returnResource(@Disposes Jedis jedis){
        jedisPool.returnResourceObject(jedis);
    }
}