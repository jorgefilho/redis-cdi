package me.jorgefilho.poc.rediscdi.repository.impl;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import me.jorgefilho.poc.rediscdi.domain.EntityStatus;
import me.jorgefilho.poc.rediscdi.repository.EntityStatusRepository;
import redis.clients.jedis.Jedis;

@RequestScoped
public class EntityStatusRepositoryImpl implements EntityStatusRepository {

	private static final long serialVersionUID = 1L;

	@Inject
	private Jedis jedis;

	@Override
	public void insert(final EntityStatus status) {
		
		final long result = jedis.hset(status.getId(), status.getSystem().toString(), status.getSystem());
		
		System.out.println("result: " +  result);
		
	}
}
