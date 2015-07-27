package me.jorgefilho.poc.rediscdi.factory;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Singleton;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

import redis.clients.jedis.JedisPool;

@ApplicationScoped
public class JedisPoolFactory {
	
	@Inject
    private JedisPool jedisPool;
    
    @Singleton
    public @Produces JedisPool getJedisPool(){
    	
        this.jedisPool = new JedisPool(new GenericObjectPoolConfig(), "127.0.0.1", 6379, 5000); // default from redis 
        return this.jedisPool;
    }
 
    public void detroy(@Disposes JedisPool jedisPool){
        this.jedisPool = jedisPool;
		jedisPool.destroy();
    }
}
