package me.jorgefilho.poc.rediscdi.factory;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@ApplicationScoped
public class JedisConnectionFactory {
	
	@Inject
    private JedisPool jedisPool;
 
    @Produces
    public Jedis getJedis(){
        return jedisPool.getResource();
    }
 
    public void returnResource(@Disposes Jedis jedis){
        jedisPool.returnResourceObject(jedis);
    }
}
