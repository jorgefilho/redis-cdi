package me.jorgefilho.poc.rediscdi.repository;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import me.jorgefilho.poc.rediscdi.domain.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String>{
	public List<Customer> findAll();
	public Customer findByid(Integer id);
}
