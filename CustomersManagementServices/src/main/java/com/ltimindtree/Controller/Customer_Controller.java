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
import com.ltimindtree.Model.Customer;
import com.ltimindtree.Service.Customer_Service;

@RestController
@RequestMapping("api/customer")
public class Customer_Controller {

	Logger logger=LoggerFactory.getLogger(Customer_Controller.class);
	
	@Autowired
	private Customer_Service Service;
	
	@GetMapping
	 public List<Customer> allCustomer(){
		logger.info("Retreiving all Customers");
		 return Service.getAllCustomer();
	}
	 
	 @GetMapping("/{customerId}")
	 public ResponseEntity<Customer> fetchOrderCustomerDetailsBYId(@PathVariable("customerId") long customer_id) throws Exception{
		 Customer detailsFetched=Service.getCustomerById(customer_id);
			logger.info("Fetching all Customers by Id");
		 if(detailsFetched==null) {
			 throw new InvalidIdException("Invalid Id!!");			 
		 }
		 return new ResponseEntity<Customer>(detailsFetched,HttpStatus.OK);
	}
	 
	 @PostMapping
	 public ResponseEntity<Customer>registerCustomer( @RequestBody Customer customer){
		 Customer registered=Service.registerCustomer(customer);
			logger.info("Adding New Customer");
		 return new ResponseEntity<Customer>(registered,HttpStatus.CREATED);
	 }
	 
	 @PutMapping("/{CustomerId}")
	 public ResponseEntity<Customer> UpdateOrderDetailsBYId(
			 @PathVariable("CustomerId") long Customer_Id,@RequestBody Customer customer) throws Exception{
		 Customer updatedDetails=Service.updateCustomerById(Customer_Id, customer);
			logger.info("Updating details of Cutomer");
		 if(updatedDetails==null) {
			throw new NoDataFoundException("No Such Data Found! ");		 
		 }
		 return new ResponseEntity<Customer>(updatedDetails,HttpStatus.OK);
	 }
	 
	 @DeleteMapping("/{CustomerId}")
	 public ResponseEntity<Customer> cancelOrderById(@PathVariable("CustomerId") long Customer_Id ){
		 Service.deactivateCustomer(Customer_Id);
			logger.info("Deleting Customer !!");
		 return new ResponseEntity<Customer>(HttpStatus.NO_CONTENT);
	 }
}
