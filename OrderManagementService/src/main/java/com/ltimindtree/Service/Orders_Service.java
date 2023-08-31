package com.ltimindtree.Service;

import java.util.List;

import com.ltimindtree.Model.Orders;

public interface Orders_Service {

		List<Orders> viewOrderDetails();

		Orders getOrderDetailsById(long Order_Id);
		
		Orders updateOrderById(long Order_Id,Orders order);

		Orders placeOrder(Orders order);

		void cancelOrderById(long Order_Id);
		
}