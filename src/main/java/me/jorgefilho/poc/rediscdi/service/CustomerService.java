package me.jorgefilho.poc.rediscdi.service;

import java.io.Serializable;
import java.util.List;

import me.jorgefilho.poc.rediscdi.domain.Customer;

public interface CustomerService extends Serializable {
	List<Customer> getAll();
}
