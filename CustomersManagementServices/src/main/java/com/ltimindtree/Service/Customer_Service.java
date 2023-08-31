package com.ltimindtree.Service;

import java.util.List;

import com.ltimindtree.Model.Customer;

public interface Customer_Service {

	List<Customer> getAllCustomer();
	
	Customer getCustomerById(long customer_id);
	
	Customer registerCustomer(Customer customer);
	
	Customer updateCustomerById(long customer_id,Customer customer);
	
	void deactivateCustomer(long customer_id);

}
