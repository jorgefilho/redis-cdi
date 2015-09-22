package me.jorgefilho.poc.rediscdi.repository.impl;

import javax.inject.Inject;

import org.jglue.cdiunit.AdditionalClasses;
import org.jglue.cdiunit.CdiRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;

import me.jorgefilho.poc.rediscdi.domain.EntityStatus;
import me.jorgefilho.poc.rediscdi.repository.EntityStatusRepository;
import redis.clients.jedis.Jedis;

@RunWith(CdiRunner.class)
@AdditionalClasses({EntityStatusRepositoryImpl.class, Jedis.class})
public class EntityStatusRepositoryImplTest {
	
	@Inject
	private EntityStatusRepository repository;
	
	@Spy
	private Jedis jedis;

	@Test
	public void insert() {
		
		final EntityStatus entityStatus = new EntityStatus("nsi-service-atg", "Brand", "Marca_01", null,  null, null);
		
		repository.insert(entityStatus );
	}

}
