package com.food.ordering.entities;

import java.util.Date;

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

@Entity
@Table(name="order_payment")
public class Payment 
{
	@Id
	@Column(name="payment_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int paymentId;
	
	@Column(name="total_amount",length=60,nullable=false)
	private double amount;
	
	@Column(name="payment_date",length=60,nullable=false)
	private Date paymentDate;
	

	@OneToOne(mappedBy="payment")
	private Order order;
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="add_to_cart_id")
	private AddToCart addToCart;

	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Payment(int paymentId, double amount, Date paymentDate, Order order, AddToCart addToCart) {
		super();
		this.paymentId = paymentId;
		this.amount = amount;
		this.paymentDate = paymentDate;
		this.order = order;
		this.addToCart = addToCart;
	}

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
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
		return "Payment [paymentId=" + paymentId + ", amount=" + amount + ", paymentDate=" + paymentDate + ", order="
				+ order + ", addToCart=" + addToCart + "]";
	}

}
