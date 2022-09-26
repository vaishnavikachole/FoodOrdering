package com.food.ordering.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Address 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="customer_address",nullable=false)
	private String customerAddress;
	@Column(name="city_name",nullable=false)
	private String city;
	@Column(name="state_name",nullable=false)
	private String state;
	@Column(name = "country_name",nullable=false)
	private String country;
	
	@JsonIgnore	
	@OneToOne(mappedBy = "address")
	private Customer customer;
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Address(int id, String customerAddress, String city, String state, String country) {
		super();
		this.id = id;
		this.customerAddress = customerAddress;
		this.city = city;
		this.state = state;
		this.country = country;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", customerAddress=" + customerAddress + ", city=" + city + ", state=" + state + ", country="
				+ country + "]";
	}
	
	

}
