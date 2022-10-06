package com.food.ordering.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.food.ordering.entities.Customer;
import com.food.ordering.service.CustomerService;


@RestController
@RequestMapping("/rest/food")
public class CustomerController 
{
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/add/customer")
	public ResponseEntity<String> saveCustomer(@RequestBody Customer customer)
	{
		ResponseEntity<String> response=null;
		try
		{
			if(customer.getCustomerId() !=0 && customerService.isCustomerExist(customer.getCustomerId()))
			{
				response = new ResponseEntity<String>("Given " +customer.getCustomerId()+" alredy exist", HttpStatus.BAD_REQUEST);
			}
			else
			{
				customerService.saveCustomer(customer);
				response = new ResponseEntity<String>("Customer with " +customer.getCustomerId() +"save successfully", HttpStatus.CREATED);
			}
		}
		catch(Exception e)
		{
			response = new ResponseEntity<String>("Unable to save Customer", HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return response;
		
		
	}
	

	@GetMapping("/one/{customerId}")
	public ResponseEntity<?> getOneCustomer(@PathVariable Integer customerId)
	{
		ResponseEntity<?> response = null;
		try
		{
			Customer customer = customerService.getOneCustomer(customerId);
			if(customer != null)
			{
		
				response = new ResponseEntity<Customer>(customer, HttpStatus.OK);
			}
			else
			{
				response =new ResponseEntity<String>("Customer not found",HttpStatus.BAD_REQUEST);
			}
		}
		catch(Exception e)
		{
			response =new ResponseEntity<String>("Uable to fetch customer",HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return response;
		
	}
	@GetMapping("/get/all")
	public ResponseEntity<?> getAllCustomers()
	{
		ResponseEntity<?> response =null;
		try {
			List<Customer> list=customerService.getAllCustomer();
			response = new ResponseEntity<List<Customer>>(list,HttpStatus.OK);
			
		}
		catch(Exception e)
		{
			response = new ResponseEntity<String>("Unable to fetch record",HttpStatus.INTERNAL_SERVER_ERROR);
					e.printStackTrace();
		}
		return response;
	}
	
	@PutMapping("/update/customer")
	public ResponseEntity<String> updateCustomer(@RequestBody Customer customer)
	{
		ResponseEntity<String> response =null;
		try
		{
			if(customer.getCustomerId()!=0 && customerService.isCustomerExist(customer.getCustomerId()))
			{
				Customer updatedCustomer = customerService.updateCustomer(customer);
				response = new ResponseEntity<String>("customer updated successfully",HttpStatus.OK);
			}
			else
			{
				response = new ResponseEntity<String>("customer with this id is not present",HttpStatus.NOT_FOUND);
			}
		}
		catch(Exception e)
		{
			response = new ResponseEntity<String>("Unable to update record",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}
	
	@DeleteMapping("/delete/{customerId}")
	public ResponseEntity<String> deleteCustomer(@PathVariable Integer customerId)
	{
		ResponseEntity<String> response = null;
		try {
			if(customerService.isCustomerExist(customerId) && customerId !=null)
			{
				customerService.deleteCustomer(customerId);
				response = new ResponseEntity<String>("customer deleted successfully",HttpStatus.OK);
			}
			else
			{
				response = new ResponseEntity<String>("customer with this id is not present",HttpStatus.NOT_FOUND);
			}
		}
		catch(Exception e)
		{
			response = new ResponseEntity<String>("Unable to delete record",HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return response;
		
	}
}