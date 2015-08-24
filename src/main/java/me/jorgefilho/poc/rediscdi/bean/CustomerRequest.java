package me.jorgefilho.poc.rediscdi.bean;


import java.io.Serializable;
import java.util.List;

import me.jorgefilho.poc.rediscdi.domain.Customer;

public class CustomerRequest implements Serializable{
	
	private static final long serialVersionUID = 1L;

	Customer customer;

	public CustomerRequest(final Customer customer) {
		this.customer = customer;
	}

	public Customer getCustomer() {
		return customer;
	}

	@Override
	public String toString() {
		return "CustomerRequest [customer=" + customer + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
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
		CustomerRequest other = (CustomerRequest) obj;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		return true;
	}
}
