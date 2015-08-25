package me.jorgefilho.poc.rediscdi.service.impl;

import me.jorgefilho.poc.rediscdi.domain.Customer;
import me.jorgefilho.poc.rediscdi.repository.CustomerRepository;
import me.jorgefilho.poc.rediscdi.service.CustomerService;

import javax.inject.Inject;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {
	
	@Inject
	private CustomerRepository customerRepository;

	private static final long serialVersionUID = 1L;

	@Override
	public List<Customer> getAll() {
		return customerRepository.findAll();
	}

	@Override
	public Customer getById(final Integer id) {
		return customerRepository.findByid(id);
	}

	@Override
	public Customer insert(final Customer customer) {
		final Customer customerSaved = customerRepository.save(customer);
		return customerSaved;
	}
}
