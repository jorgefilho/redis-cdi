package me.jorgefilho.poc.rediscdi.repository.impl;

import me.jorgefilho.poc.rediscdi.repository.CacheRepository;
import redis.clients.jedis.Jedis;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class CacheRepositoryImpl implements CacheRepository {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Jedis jedis;
	
	@Override
	public  String setex(String key, int timeToExpire, String json){
		final String statusCode = jedis.setex(key, timeToExpire, json);
		return statusCode;
	}
	@Override
	public String get(String key) {
		return jedis.get(key);
	}
}