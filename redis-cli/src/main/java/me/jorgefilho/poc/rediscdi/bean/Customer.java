package me.jorgefilho.poc.rediscdi.bean;

import java.io.Serializable;

public class Customer implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String name;
	
	private String email;

	public Customer(String name, String email) {
		this.name = name;
		this.email = email;
	}
	public String getEmail() {
		return email;
	}
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return "CustomerResponse [name=" + name + ", email=" + email + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Customer other = (Customer) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
