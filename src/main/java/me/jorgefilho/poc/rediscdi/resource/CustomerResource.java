package me.jorgefilho.poc.rediscdi.resource;

import java.io.Serializable;

import me.jorgefilho.poc.rediscdi.bean.CustomerResponse;

public interface CustomerResource extends Serializable{
	CustomerResponse getAll();
	CustomerResponse getById(String id);
}
