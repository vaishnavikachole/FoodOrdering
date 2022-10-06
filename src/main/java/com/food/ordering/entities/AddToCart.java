package com.food.ordering.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="add_to_cart")
public class AddToCart 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="add_to_cart_id")
	private int addToCartId;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER,mappedBy="addToCart")
	private Set<MenuItem> menuItem;
	
	@Column(name="item_quantity",length=60,nullable=false)
	private int quantity;
	
	@OneToOne(mappedBy="addToCart")
	private Customer customer;
	
//	@OneToOne(mappedBy="addToCart")
//	private Payment payment;

	public AddToCart() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public AddToCart(int addToCartId, Set<MenuItem> menuItem, int quantity, Customer customer) {
		super();
		this.addToCartId = addToCartId;
		this.menuItem = menuItem;
		this.quantity = quantity;
		this.customer = customer;
	}

	public int getAddToCartId() {
		return addToCartId;
	}

	public void setAddToCartId(int addToCartId) {
		this.addToCartId = addToCartId;
	}

	public Set<MenuItem> getMenuItem() {
		return menuItem;
	}

	public void setMenuItem(Set<MenuItem> menuItem) {
		this.menuItem = menuItem;
	}
	

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "AddToCart [addToCartId=" + addToCartId + ", menuItem=" + menuItem + ", quantity=" + quantity
				+ ", customer=" + customer + "]";
	}

	
}
