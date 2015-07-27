package me.jorgefilho.poc.rediscdi.resource.impl;

import static me.jorgefilho.poc.rediscdi.resource.constants.ResourceConstants.JSON_UTF_8;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;
import javax.websocket.server.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import me.jorgefilho.poc.rediscdi.annotation.Cached;
import me.jorgefilho.poc.rediscdi.bean.CustomerResponse;
import me.jorgefilho.poc.rediscdi.domain.Customer;
import me.jorgefilho.poc.rediscdi.resource.CustomerResource;
import me.jorgefilho.poc.rediscdi.service.CustomerService;

@Path("/api")
public class CustomerResourceImpl implements CustomerResource{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private CustomerService customerService;
	
	@GET
	@Path("/customers")
	@Produces(JSON_UTF_8)
	@Cached(expireInSeconds=6000)
	@Override
	public CustomerResponse getAll(){
		final List<Customer> customers = customerService.getAll();
		
		final CustomerResponse customerResponse = new CustomerResponse(customers);
		
		return customerResponse;
	}

	@GET
	@Path("/customers/{id}")
	@Produces(JSON_UTF_8)
	@Override
	public CustomerResponse getById(@PathParam("id") final int id) {
		
		final Customer customer = customerService.getById(Integer.valueOf(id));
		
		final CustomerResponse customerResponse = new CustomerResponse(Arrays.asList(customer));
		
		return customerResponse;
	}
}
