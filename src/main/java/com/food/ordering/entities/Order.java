package com.food.ordering.entities;

import java.util.Date;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="customer_order")
public class Order 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="order_id")
	private int orderId;
	
	@Column(name="order_number",length=60,unique=true,nullable=false)
	private long orderNumber;
	
	@Temporal(TemporalType.DATE)
	@Column(name="order_date",length=60,nullable=false)
	private Date orderDate;
	
	@Column(name="total_amount",length=60,nullable=false)
	private double totalAmount;
	
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER,mappedBy="order")
	private List<Address> deliveryAddress;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER,mappedBy="order")
	private Set<OrderDetails> orderDetails;
	
//	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
//	@JoinColumn(name="order_payment")
//	private Payment payment;

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(int orderId, long orderNumber, Date orderDate, double totalAmount, Customer customer,
			List<Address> deliveryAddress, Set<OrderDetails> orderDetails) {
		super();
		this.orderId = orderId;
		this.orderNumber = orderNumber;
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
		this.customer = customer;
		this.deliveryAddress = deliveryAddress;
		this.orderDetails = orderDetails;

	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public Set<OrderDetails> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(Set<OrderDetails> orderDetails) {
		this.orderDetails = orderDetails;
	}
	
	public long getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(long orderNumber) {
		this.orderNumber = orderNumber;
	}

	public List<Address> getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(List<Address> deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderNumber=" + orderNumber + ", orderDate=" + orderDate
				+ ", totalAmount=" + totalAmount + ", customer=" + customer + ", deliveryAddress=" + deliveryAddress
				+ ", orderDetails=" + orderDetails + "]";
	}
	

	
	
	

}
