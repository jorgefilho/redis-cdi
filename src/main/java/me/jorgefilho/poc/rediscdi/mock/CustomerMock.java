package me.jorgefilho.poc.rediscdi.mock;

import java.util.Arrays;
import java.util.List;

import me.jorgefilho.poc.rediscdi.domain.Customer;

public class CustomerMock {
	
	private	final List<Customer> customers = Arrays.asList(build(1, "José da Silva", "jose.silva@email.com"),
														   build(2, "Joaquim Oliveira", "joaquim.oliveira@email.com"),
														   build(3, "Maria de Lurdes", "maria.lurdes@email.com"),
														   build(4, "Claudia Mendes", "claudia.mendes@email.com"));

	public List<Customer> getAll(){
		return customers;
	}
	
	private Customer build(final Integer id, final String name, final String email){
		return new Customer(id, name, email);
	}
}
