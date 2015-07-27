package me.jorgefilho.poc.rediscdi.mock;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.RequestScoped;

import me.jorgefilho.poc.rediscdi.domain.Customer;

@RequestScoped
public class CustomerRepositoryMock {
	
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

	public Customer getById(Integer id) {
		Optional<Customer> possibleCustomer = this.customers.stream()
													.filter(c->c.getId().equals(id))
													.findFirst();
		
		return possibleCustomer.isPresent()?possibleCustomer.get():null;
	}
}
