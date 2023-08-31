package com.ltimindtree.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ltimindtree.Model.Customer;
import com.ltimindtree.Repository.Customer_Repository;

@Service
public class CustomerServiceImpl implements Customer_Service {

	@Autowired
	private Customer_Repository repository;
	
	@Override
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Customer getCustomerById(long customer_id) {
		// TODO Auto-generated method stub
		return repository.findById(customer_id).get();
	}

	@Override
	public Customer registerCustomer(Customer customer) {
	
		return repository.save(customer);
	}

	@Override
	public Customer updateCustomerById(long customer_id, Customer customer) {
		Customer updatedCustomer=repository.findById(customer_id).get();
		
		if(updatedCustomer!=null) {
			
			updatedCustomer.setCustomer_name(updatedCustomer.getCustomer_name());
			updatedCustomer.setCustomer_age(updatedCustomer.getCustomer_age());
		}
		return repository.save(updatedCustomer);
	}

	@Override
	public void deactivateCustomer(long customer_id) {
		// TODO Auto-generated method stub
		repository.deleteById(customer_id);
	}

}
