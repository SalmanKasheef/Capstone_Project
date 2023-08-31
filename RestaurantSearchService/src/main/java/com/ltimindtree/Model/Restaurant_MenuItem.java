package com.ltimindtree.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="menuItem")

public class Restaurant_MenuItem {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="menu_id")
	private Long menu_id;
	
	private String name;
	
	private String description;
	
	private int price;
	


	public Restaurant_MenuItem(Long menu_id, String name, String description, int price) {
		super();
		this.menu_id = menu_id;
		this.name = name;
		this.description = description;
		this.price = price;
	}

	public Restaurant_MenuItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getMenu_id() {
		return menu_id;
	}

	public void setMenu_id(Long menu_id) {
		this.menu_id = menu_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
}
