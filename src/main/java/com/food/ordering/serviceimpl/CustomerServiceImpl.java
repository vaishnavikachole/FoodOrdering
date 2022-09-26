package com.food.ordering.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.ordering.dao.CustomerDao;
import com.food.ordering.entities.Customer;
import com.food.ordering.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService 
{
	@Autowired
	private CustomerDao customerDao;

	@Override
	public Integer saveCustomer(Customer customer) {
		return customerDao.save(customer).getCustomerId();
	}

	@Override
	public boolean isCustomerExist(int customerId) {
		return customerDao.existsById(customerId);
	}

	@Override
	public List<Customer> getAllCustomer() {
		
		return customerDao.findAll();
	}

	@Override
	public Customer getOneCustomer(int customerId) {
		// TODO Auto-generated method stub
	    Customer customer = customerDao.getCustomerByCustomerId(customerId);
		
		return customer;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		
		return customerDao.save(customer);
	}

	public void deleteCustomer(int customerId)
	{
		customerDao.deleteCustomerByCustomerId(customerId);
		
	}
	


}
