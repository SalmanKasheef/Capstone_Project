package com.ltimindtree.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ltimindtree.Exception.InvalidIdException;
import com.ltimindtree.Exception.NoDataFoundException;
import com.ltimindtree.Model.Orders;
import com.ltimindtree.Service.Orders_Service;  

@RestController
@RequestMapping("api/orders")
public class Orders_Controller {

	Logger logger=LoggerFactory.getLogger(Orders_Controller.class);
	
	@Autowired
	private Orders_Service Service;
	
	@GetMapping
	 public List<Orders> allOrders(){
		logger.info("Retreving all Orders ");
		 return Service.viewOrderDetails();
	}
	 
	 @GetMapping("/{orderId}")
	 public ResponseEntity<Orders> fetchOrderDetailsBYId(@PathVariable("orderId") long Order_Id) throws Exception{
		 Orders detailsFetched=Service.getOrderDetailsById(Order_Id);
		 logger.info("Fetching Orders ");
		 if(detailsFetched==null) {
			 throw new InvalidIdException("Invalid Id!!");			 
		 }
		 return new ResponseEntity<Orders>(detailsFetched,HttpStatus.OK);
	}
	 
	 @PostMapping
	 public ResponseEntity<Orders>placeOrder( @RequestBody Orders order){
		 Orders orderPlaced=Service.placeOrder(order);
		 logger.info("PLacing Order");
		 return new ResponseEntity<Orders>(orderPlaced,HttpStatus.CREATED);
	 }
	 
	 @PutMapping("/{orderId}")
	 public ResponseEntity<Orders> UpdateOrderDetailsBYId(
			 @PathVariable("orderId") long Order_Id,@RequestBody Orders order) throws Exception{
		 Orders updatedDetails=Service.updateOrderById(Order_Id, order);
		 logger.info("Updating Order !!");
		 if(updatedDetails==null) {
			throw new NoDataFoundException("No Such Data Found! ");		 
		 }
		 return new ResponseEntity<Orders>(updatedDetails,HttpStatus.OK);
	 }
	 
	 @DeleteMapping("/{orderId}")
	 public ResponseEntity<Orders> cancelOrderById(@PathVariable("orderId") long Order_Id ){
		 Service.cancelOrderById(Order_Id);
		 logger.info("Deleting order");
		 return new ResponseEntity<Orders>(HttpStatus.NO_CONTENT);
	 }
}
