package me.jorgefilho.poc.rediscdi.service.impl;

import java.util.List;

import javax.inject.Inject;

import me.jorgefilho.poc.rediscdi.domain.Customer;
import me.jorgefilho.poc.rediscdi.mock.CustomerRepositoryMock;
import me.jorgefilho.poc.rediscdi.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {
	
	@Inject
	private CustomerRepositoryMock customerRepositoryMock;

	private static final long serialVersionUID = 1L;

	@Override
	public List<Customer> getAll() {
		return customerRepositoryMock.getAll();
	}

	@Override
	public Customer getById(Integer id) {
		return customerRepositoryMock.getById(id);
	}

}
