package me.jorgefilho.poc.rediscdi.resource.impl;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import me.jorgefilho.poc.rediscdi.bean.CustomerResponse;
import me.jorgefilho.poc.rediscdi.domain.Customer;
import me.jorgefilho.poc.rediscdi.resource.CustomerResource;
import me.jorgefilho.poc.rediscdi.service.CustomerService;

@Path("/customer")
public class CustomerResourceImpl implements CustomerResource{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private CustomerService customerService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public CustomerResponse getAll(){
		final List<Customer> customers = customerService.getAll();
		
		final CustomerResponse customerResponse = new CustomerResponse(customers);
		
		return customerResponse;
	}
}
