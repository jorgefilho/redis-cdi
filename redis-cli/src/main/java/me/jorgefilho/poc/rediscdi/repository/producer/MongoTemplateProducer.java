package me.jorgefilho.poc.rediscdi.repository.producer;

import com.mongodb.MongoClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import java.io.Serializable;
import java.net.UnknownHostException;

public class MongoTemplateProducer implements Serializable {

	private static final long serialVersionUID = 1L;

	private final static Logger LOGGER = LoggerFactory.getLogger(MongoTemplateProducer.class);

	private MongoClient mongoClient;

    @Produces
    @ApplicationScoped
    public MongoOperations produce(){
        return this.createMongoTemplate();
    }

    private MongoDbFactory  getMongoDbFactory() {
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

    private MongoOperations createMongoTemplate() {
        return new MongoTemplate(getMongoDbFactory());
    }
}
