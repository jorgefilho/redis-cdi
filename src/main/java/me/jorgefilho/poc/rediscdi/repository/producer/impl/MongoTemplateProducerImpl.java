package me.jorgefilho.poc.rediscdi.repository.producer.impl;

import java.net.UnknownHostException;

import javax.enterprise.context.ApplicationScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.MongoClient;

import me.jorgefilho.poc.rediscdi.repository.producer.MongoTemplateProducer;

@ApplicationScoped
public class MongoTemplateProducerImpl implements MongoTemplateProducer {

	private final static Logger LOGGER = LoggerFactory.getLogger(MongoTemplateProducerImpl.class);

	private MongoClient mongoClient;

	private MongoDbFactory getMongoDbFactory() {
		MongoDbFactory factory = null;

		try {
			if (this.mongoClient == null) {
				this.mongoClient = new MongoClient("127.0.0.1", 27017);
			}

			factory = new SimpleMongoDbFactory(this.mongoClient, "redis-cdi");
		} catch (UnknownHostException e) {
			LOGGER.error("Unknown host {}", e.getMessage());
		} catch (Exception e) {
			LOGGER.error("Unexpected error {}", e.getMessage(), e);
		}

		return factory;
	}
}
