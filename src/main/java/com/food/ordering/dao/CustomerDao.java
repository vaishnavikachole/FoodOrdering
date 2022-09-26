package com.food.ordering.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.food.ordering.entities.Customer;

@Repository
@Transactional
public interface CustomerDao extends JpaRepository<Customer,Integer>
{
	@Query(value="SELECT customer FROM Customer customer WHERE customerId = :customerId")
	public Customer getCustomerByCustomerId(@Param("customerId") Integer customerId);
	
	@Modifying
	@Query(value="DELETE FROM Customer customer WHERE customer.customerId = :id")
	public void deleteCustomerByCustomerId(@Param("id") Integer customerId);
	
	
}
