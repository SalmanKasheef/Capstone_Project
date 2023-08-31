package com.ltimindtree.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders {

	private long order_id;
	private String order_items;
	private String no_of_items;
	private double total_amount;
	
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Orders(int order_id, String order_items, String no_of_items, double total_amount) {
		super();
		this.order_id = order_id;
		this.order_items = order_items;
		this.no_of_items = no_of_items;
		this.total_amount = total_amount;
	}

	public long getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public String getOrder_items() {
		return order_items;
	}

	public void setOrder_items(String order_items) {
		this.order_items = order_items;
	}

	public String getNo_of_items() {
		return no_of_items;
	}

	public void setNo_of_items(String no_of_items) {
		this.no_of_items = no_of_items;
	}

	public double getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(double total_amount) {
		this.total_amount = total_amount;
	}
	
}
