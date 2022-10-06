package com.food.ordering.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="order_details")
public class OrderDetails
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="order_details_id")
	private int orderDetailsId;
	
	@Column(name="item_amount",length=60,nullable=false)
	private double amount;
	
	@Column(name="item_quantity",length=60,nullable=false)
	private int quantity;
	
	@Column(name="total_amount",length=60,nullable=false)
	private double totalAmount;
	
	@ManyToOne
	@JoinColumn(name="order_id")
	private Order order;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER,mappedBy="orderDetails")
	private Set<MenuItem> menuItem;

	public OrderDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderDetails(int orderDetailsId, double amount, int quantity, double totalAmount, Order order,
			Set<MenuItem> menuItem) {
		super();
		this.orderDetailsId = orderDetailsId;
		this.amount = amount;
		this.quantity = quantity;
		this.totalAmount = totalAmount;
		this.order = order;
		this.menuItem = menuItem;
	}

	public int getOrderDetailsId() {
		return orderDetailsId;
	}

	public void setOrderDetailsId(int orderDetailsId) {
		this.orderDetailsId = orderDetailsId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Set<MenuItem> getMenuItem() {
		return menuItem;
	}

	public void setMenuItem(Set<MenuItem> menuItem) {
		this.menuItem = menuItem;
	}

	@Override
	public String toString() {
		return "OrderDetails [orderDetailsId=" + orderDetailsId + ", amount=" + amount + ", quantity=" + quantity
				+ ", totalAmount=" + totalAmount + ", order=" + order + ", menuItem=" + menuItem + "]";
	}

	
}
