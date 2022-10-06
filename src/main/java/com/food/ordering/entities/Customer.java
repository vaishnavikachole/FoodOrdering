package com.food.ordering.entities;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER,mappedBy="customer")
	private List<Address> address;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER,mappedBy="customer")
	private Set<Order> order;
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="add_to_cart_id")
	private AddToCart addToCart;
	
	public Customer() {
		super();
	}
	
	public Customer(int customerId, String customerName, String customerEmail, String password, long customerMobile,
			List<Address> address, Set<Order> order, AddToCart addToCart) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.password = password;
		this.customerMobile = customerMobile;
		this.address = address;
		this.order = order;
		this.addToCart = addToCart;
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
	
	public List<Address> getAddress() {
		return address;
	}


	public void setAddress(List<Address> address) {
		this.address = address;
	}


	public Set<Order> getOrder() {
		return order;
	}

	public void setOrder(Set<Order> order) {
		this.order = order;
	}
	

	public AddToCart getAddToCart() {
		return addToCart;
	}

	public void setAddToCart(AddToCart addToCart) {
		this.addToCart = addToCart;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerEmail="
				+ customerEmail + ", password=" + password + ", customerMobile=" + customerMobile + ", address="
				+ address + ", order=" + order + ", addToCart=" + addToCart + "]";
	}

	

	
}
