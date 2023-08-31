package com.ltimindtree.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ltimindtree.Model.Orders;
import com.ltimindtree.Repository.Orders_Repository;

@Service
public class OrdersServiceImpl implements Orders_Service {

	@Autowired
	private Orders_Repository repository;

	@Override
	public List<Orders> viewOrderDetails() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Orders getOrderDetailsById(long Order_Id) {
		// TODO Auto-generated method stub
		return repository.findById(Order_Id).get();
	}

	@Override
	public Orders updateOrderById(long Order_Id, Orders order) {
		
		Orders updatedOrder=repository.findById(Order_Id).get();
		if(updatedOrder!=null) {
			updatedOrder.setOrder_items(updatedOrder.getOrder_items());
			updatedOrder.setNo_of_items(updatedOrder.getNo_of_items());
			updatedOrder.setTotal_amount(updatedOrder.getTotal_amount());
		}
		
		return repository.save(updatedOrder);
	}

	@Override
	public Orders placeOrder(Orders order) {
		// TODO Auto-generated method stub
		return repository.save(order);
	}

	@Override
	public void cancelOrderById(long Order_Id) {
		// TODO Auto-generated method stub
		repository.deleteById(Order_Id);
	}
	
	

}
