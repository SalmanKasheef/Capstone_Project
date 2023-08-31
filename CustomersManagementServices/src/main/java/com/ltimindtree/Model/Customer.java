package com.ltimindtree.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="customer")
@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Customer_Id;
	
	private String Customer_name;
	
	private int Customer_age;
	
	
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(int customer_Id, String customer_name, int customer_age) {
		super();
		Customer_Id = customer_Id;
		Customer_name = customer_name;
		Customer_age = customer_age;
	}

	public int getCustomer_Id() {
		return Customer_Id;
	}

	public void setCustomer_Id(int customer_Id) {
		Customer_Id = customer_Id;
	}

	public String getCustomer_name() {
		return Customer_name;
	}

	public void setCustomer_name(String customer_name) {
		Customer_name = customer_name;
	}

	public int getCustomer_age() {
		return Customer_age;
	}

	public void setCustomer_age(int customer_age) {
		Customer_age = customer_age;
	}

	

	
}
