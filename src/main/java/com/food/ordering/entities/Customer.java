package com.food.ordering.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(value= {"handler","hibernateLazyInitializer","FieldHandler"})
@Table(name="customer_details")
public class Customer 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="customer_id")
	private int customerId;
	
	@Column(name="customer_name",length=60,nullable=false)
	private String customerName;
	
	@Column(name="customer_email",length=90,unique=true,nullable=false)
	private String customerEmail;
	
	@Column(name="customer_password",length=60,nullable=false)
	private String password;
	
	@Column(name="mobile_number",length=60,nullable=false)
	private long customerMobile;
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="customer_address_fk")
	private Address address;
	
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Customer(int customerId, String customerName, String customerEmail, String password, long customerMobile,
			Address address) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.password = password;
		this.customerMobile = customerMobile;
		this.address = address;
	}


	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public long getCustomerMobile()
	{
		return customerMobile;
	}
	public void setCustomerMobile(long customerMobile)
	{
		this.customerMobile = customerMobile;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}


	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerEmail="
				+ customerEmail + ", password=" + password + ", customerMobile=" + customerMobile + ", address="
				+ address + "]";
	}
	
	

	
	
	


}
