package me.jorgefilho.poc.rediscdi.bean;

import java.io.Serializable;
import java.util.List;

import me.jorgefilho.poc.rediscdi.domain.Customer;



public class CustomerResponse implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private List<Customer> customers;

	public CustomerResponse(List<Customer> customers) {
		this.customers = customers;
	}
	public List<Customer> getCustomers() {
		return customers;
	}
	@Override
	public String toString() {
		return "CustomerResponse [customers=" + customers + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customers == null) ? 0 : customers.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerResponse other = (CustomerResponse) obj;
		if (customers == null) {
			if (other.customers != null)
				return false;
		} else if (!customers.equals(other.customers))
			return false;
		return true;
	}
}
