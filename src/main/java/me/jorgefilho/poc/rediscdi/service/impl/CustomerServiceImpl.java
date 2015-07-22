package me.jorgefilho.poc.rediscdi.service.impl;

import java.util.List;

import javax.inject.Inject;

import me.jorgefilho.poc.rediscdi.domain.Customer;
import me.jorgefilho.poc.rediscdi.repository.CustomerRepository;
import me.jorgefilho.poc.rediscdi.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {
	
	@Inject
	private CustomerRepository customerRepository;

	private static final long serialVersionUID = 1L;

	@Override
	public List<Customer> getAll() {
		return customerRepository.getAll();
	}

}
