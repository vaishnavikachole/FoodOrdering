package com.food.ordering.service;

import java.util.List;

import com.food.ordering.entities.Customer;


public interface CustomerService {
	public Integer saveCustomer(Customer customer);

	public boolean isCustomerExist(int customerId);

    public Customer getOneCustomer(int customerId);

	public List<Customer> getAllCustomer();
	
	public Customer updateCustomer(Customer customer);
	
	public void deleteCustomer(int customerId);
}
