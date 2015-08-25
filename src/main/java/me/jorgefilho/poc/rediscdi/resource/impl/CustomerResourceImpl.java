package me.jorgefilho.poc.rediscdi.resource.impl;

import static me.jorgefilho.poc.rediscdi.resource.constants.ResourceConstants.JSON_UTF_8;

import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import me.jorgefilho.poc.rediscdi.annotation.Cached;
import me.jorgefilho.poc.rediscdi.bean.CustomerRequest;
import me.jorgefilho.poc.rediscdi.bean.CustomerResponse;
import me.jorgefilho.poc.rediscdi.domain.Customer;
import me.jorgefilho.poc.rediscdi.resource.CustomerResource;
import me.jorgefilho.poc.rediscdi.service.CustomerService;

@RequestScoped
@Path("/customers")
public class CustomerResourceImpl implements CustomerResource{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private CustomerService customerService;
	
	@POST
	@Consumes(JSON_UTF_8)
	@Produces(JSON_UTF_8)
	@Override
	public CustomerResponse insert(final CustomerRequest customerRequest) {
		
		final Customer customer = new Customer(customerRequest.getName(), customerRequest.getEmail());
		
		final Customer customerSaved = customerService.insert(customer);
	
		final CustomerResponse customerResponse = new CustomerResponse(Arrays.asList(customerSaved));
		
		return customerResponse;
	}
	
	
	@GET
	@Produces(JSON_UTF_8)
	@Cached(expireInSeconds=6000)
	@Override
	public CustomerResponse getAll(){
		final List<Customer> customers = customerService.getAll();
		
		final CustomerResponse customerResponse = new CustomerResponse(customers);
		
		return customerResponse;
	}

	@GET
	@Path("{id}")
	@Produces(JSON_UTF_8)
	@Override
	public CustomerResponse getById(@PathParam("id") final Integer  id) {
		
		final Customer customer = customerService.getById(id);
		
		final CustomerResponse customerResponse = new CustomerResponse(Arrays.asList(customer));
		
		return customerResponse;
	}
}
