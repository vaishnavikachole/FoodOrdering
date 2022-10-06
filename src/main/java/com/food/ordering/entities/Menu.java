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
import javax.persistence.Table;

@Entity
@Table(name="menu_types")
public class Menu 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="menu_id")
	private int menuId;
	
	@Column(name="menu_type",length=60,nullable=false)
	private String  menuType;   //starter ,maincourse ,dessert
	

	@Column(name="menu_desciption",length=255,nullable=false)
	private String description;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER,mappedBy="menu")
	private Set<MenuItem> menuItem;
	

	public Menu() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Menu(int menuId, String menuType,String description, Set<MenuItem> menuItem) {
		super();
		this.menuId = menuId;
		this.menuType = menuType;
		this.description = description;
		this.menuItem = menuItem;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	

	public String getMenuType() {
		return menuType;
	}


	public void setMenuType(String menuType) {
		this.menuType = menuType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	public Set<MenuItem> getMenuItem() {
		return menuItem;
	}

	public void setMenuItem(Set<MenuItem> menuItem) {
		this.menuItem = menuItem;
	}


	@Override
	public String toString() {
		return "Menu [menuId=" + menuId + ", menuType=" + menuType + ", description=" + description + ", menuItem="
				+ menuItem + "]";
	}
	
}
