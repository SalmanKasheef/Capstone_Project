package com.ltimindtree.Controller;

import java.util.List;

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
import com.ltimindtree.Model.Restaurant_MenuItem;
import com.ltimindtree.Service.MenuItem_Service;

@RestController
@RequestMapping("api/menuItem")
public class MenuItem_Controller {

	@Autowired
	private MenuItem_Service service;
	
	@GetMapping
	public ResponseEntity<?>getAllRestaurants() throws Exception{
		List<Restaurant_MenuItem> menuItem=service.listOfMenu();
		if(menuItem.isEmpty()) {
			throw new NoDataFoundException("No Data Found!!");
		}
		return ResponseEntity.ok(menuItem);
	}
	
	@GetMapping("/{menuItem_Id}")
	 public ResponseEntity<Restaurant_MenuItem> findMenuDetailsById(@PathVariable("menuItem_Id") long menuItem_Id) throws InvalidIdException{
		 Restaurant_MenuItem detailsFetched=service.findMenuById(menuItem_Id);
		 if(detailsFetched==null) {
			 throw new InvalidIdException("Invalid Menu Id");			 
		 }
		 return new ResponseEntity<Restaurant_MenuItem>(detailsFetched,HttpStatus.OK);
	}
	 @PostMapping
	 public ResponseEntity<Restaurant_MenuItem>addMenuItem( @RequestBody Restaurant_MenuItem menuItem){
		 Restaurant_MenuItem registered=service.addNewMenu(menuItem);
		 return new ResponseEntity<Restaurant_MenuItem>(registered,HttpStatus.CREATED);
	 }

	 @PutMapping("/{menuItem_Id}")
	 public ResponseEntity<Restaurant_MenuItem> UpdateMenuDetailsById(
			 @PathVariable("menuItem_Id") long menuItem_Id,@RequestBody Restaurant_MenuItem menu) throws Exception{
		 Restaurant_MenuItem updatedDetails=service.updateMenuById(menuItem_Id, menu);
		 if(updatedDetails==null) {
			 throw new InvalidIdException("There is no such Id present ,Please enter valid Id");			 
		 }
		 return new ResponseEntity<Restaurant_MenuItem>(updatedDetails,HttpStatus.OK);
	 }
	 
	 @DeleteMapping("/{menuItem_Id}")
	 public ResponseEntity<Restaurant_MenuItem> deleteMenuById
	 				(@PathVariable("menuItem_Id") long menuItem_Id ){
		 
		 service.deleteMenuById(menuItem_Id);
		 return new ResponseEntity<Restaurant_MenuItem>(HttpStatus.NO_CONTENT);
	 }
}
