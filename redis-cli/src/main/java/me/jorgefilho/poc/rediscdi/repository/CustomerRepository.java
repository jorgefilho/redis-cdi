package me.jorgefilho.poc.rediscdi.repository;


import me.jorgefilho.poc.rediscdi.domain.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CustomerRepository extends MongoRepository<Customer, String> {
	List<Customer> findAll();
	Customer findByid(Integer id);
}
