package com.food.ordering.entities;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="menu_item")
public class MenuItem
{
	@Id
	@Column(name="menu_item_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int menuItemId;
	
	@Column(name="item_type",length=60,nullable=false)
	private String itemType; //veg non-veg
	
	@Column(name="item_name",length=60,nullable=false)
	private String itemName;
	
	@Column(name="item_price",length=60,nullable=false)
	private double itemPrice;
	
	@Lob
	@Column(name="item_image",nullable=false)
	private byte[] itemImage;
	
	@ManyToOne
	@JoinColumn(name="menu_id")
	private Menu menu;

	@ManyToOne
	@JoinColumn(name="order_details_id")
	private OrderDetails orderDetails;

	@ManyToOne
	@JoinColumn(name="add_to_cart_id")
	private AddToCart addToCart;
	
	public MenuItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public MenuItem(int menuItemId, String itemType, String itemName, double itemPrice, byte[] itemImage, Menu menu,
			OrderDetails orderDetails, AddToCart addToCart) {
		super();
		this.menuItemId = menuItemId;
		this.itemType = itemType;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemImage = itemImage;
		this.menu = menu;
		this.orderDetails = orderDetails;
		this.addToCart = addToCart;
	}

	public int getMenuItemId() {
		return menuItemId;
	}

	public void setMenuItemId(int menuItemId) {
		this.menuItemId = menuItemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}

	public byte[] getItemImage() {
		return itemImage;
	}

	public void setItemImage(byte[] itemImage) {
		this.itemImage = itemImage;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public OrderDetails getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(OrderDetails orderDetails) {
		this.orderDetails = orderDetails;
	}
	

	public AddToCart getAddToCart() {
		return addToCart;
	}


	public void setAddToCart(AddToCart addToCart) {
		this.addToCart = addToCart;
	}

	@Override
	public String toString() {
		return "MenuItem [menuItemId=" + menuItemId + ", itemType=" + itemType + ", itemName=" + itemName
				+ ", itemPrice=" + itemPrice + ", itemImage=" + Arrays.toString(itemImage) + ", menu=" + menu
				+ ", orderDetails=" + orderDetails + ", addToCart=" + addToCart + "]";
	}
}
