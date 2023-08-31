package com.ltimindtree.VO;

import com.ltimindtree.Model.Restaurant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVO {

	private Restaurant restaurant;
	
	private Orders order;

	public ResponseTemplateVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ResponseTemplateVO(Restaurant restaurant, Orders order) {
		super();
		this.restaurant = restaurant;
		this.order = order;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}
	
}
