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

import com.ltimindtree.Model.Restaurant;
import com.ltimindtree.Service.Restaurant_Service;
import com.ltimindtree.VO.ResponseTemplateVO;

@RestController
@RequestMapping("api/restaurants")
public class Restaurant_Controller {

	Logger logger=LoggerFactory.getLogger(Restaurant_Controller.class);
	
	@Autowired
	private Restaurant_Service service;
	
	//Communicating to Order Service using RestTemplate
	@GetMapping("/Vo/{restaurant_id}")
	public ResponseTemplateVO getRestaurantWithOrders(@PathVariable("restaurant_id") long restaurant_id) {
		logger.info("Fetching Restaurant Orders");
		return service.getRestaurantsWithOrders(restaurant_id);
	}
	
	@GetMapping
	public ResponseEntity<?>getAllRestaurants() throws Exception{
		List<Restaurant> restaurant=service.findAllRestaurants();
		logger.info("Fetching All Restaurant!!");
		if(restaurant.isEmpty()) {
			throw new NoDataFoundException("No Data Found!!");
		}
		return ResponseEntity.ok(restaurant);
	}
	
	@GetMapping("/{restaurant_Id}")
	 public ResponseEntity<Restaurant> fetchRestaurantDetailsBYId(@PathVariable("restaurant_Id") long Restaurant_Id) throws InvalidIdException{
		 Restaurant detailsFetched=service.findRestaurantsById(Restaurant_Id);
		 logger.info("Finding Restaurant Id");
		 if(detailsFetched==null) {
			 throw new InvalidIdException("Invalid Restaurant Id");			 
		 }
		 return new ResponseEntity<Restaurant>(detailsFetched,HttpStatus.OK);
	}
	 @PostMapping
	 public ResponseEntity<Restaurant>registerCustomer( @RequestBody Restaurant restaurant){
		 Restaurant registered=service.saveRestaurantsDetails(restaurant);
		 logger.info("Saving Restaurant Details");
		 return new ResponseEntity<Restaurant>(registered,HttpStatus.CREATED);
	 }

	 @PutMapping("/{restaurant_Id}")
	 public ResponseEntity<Restaurant> UpdateRestaurantDetailsById(
			 @PathVariable("restaurant_Id") long Restaurant_Id,@RequestBody Restaurant restaurants) throws Exception{
		 Restaurant updatedDetails=service.updateRestaurantById(Restaurant_Id, restaurants);
		 logger.info("Updating Restaurant Details");
		 if(updatedDetails==null) {
			 throw new InvalidIdException("There is no such Id present ,Please enter valid Id");			 
		 }
		 return new ResponseEntity<Restaurant>(updatedDetails,HttpStatus.OK);
	 }
	 
	 @DeleteMapping("/{restaurant_Id}")
	 public ResponseEntity<Restaurant> deleteRestaurantById
	 				(@PathVariable("restaurant_Id") long Restaurant_Id ){
		 
		 service.deleteRestaurantById(Restaurant_Id);
		 logger.info("Deleting Restaurant!!");
		 return new ResponseEntity<Restaurant>(HttpStatus.NO_CONTENT);
	 }

	
}
