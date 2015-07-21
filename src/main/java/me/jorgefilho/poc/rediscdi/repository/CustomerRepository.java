package me.jorgefilho.poc.rediscdi.repository;

import java.util.List;

import me.jorgefilho.poc.rediscdi.domain.Customer;

public interface CustomerRepository {

	List<Customer> getAll();
}
