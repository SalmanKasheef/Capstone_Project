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
import com.ltimindtree.Model.Reviews;
import com.ltimindtree.Service.Review_Service;

@RestController
@RequestMapping("api/review")
public class Review_Controller {

	Logger logger=LoggerFactory.getLogger(Review_Controller.class);
	
	
	@Autowired
	private Review_Service Service;
	
	@GetMapping
	 public List<Reviews> allreviewsOfRestaurant(){
		logger.info("Fetching all Reviews");
		 return Service.getAllReviewsofRestaurant();
	}
	 
	 @GetMapping("/{reviewId}")
	 public ResponseEntity<Reviews> ReviewsOfRestaurantById(@PathVariable("reviewId") long review_id) throws Exception{
		 Reviews detailsFetched=Service.getReviewsOfRestaurantById(review_id);
		logger.info("Getting Review By Restaurant Id");
		 if(detailsFetched==null) {
			 throw new InvalidIdException("Invalid Id!!");			 
		 }
		 return new ResponseEntity<Reviews>(detailsFetched,HttpStatus.OK);
	}
	 
	 @PostMapping
	 public ResponseEntity<Reviews>registerCustomer( @RequestBody Reviews review){
		 Reviews registered=Service.providereviewAndRatings(review);
		 logger.info("Adding New Reviews and Ratings!!");
		 return new ResponseEntity<Reviews>(registered,HttpStatus.CREATED);
	 }
	 
	 @PutMapping("/{reviewId}")
	 public ResponseEntity<Reviews> UpdateOrderDetailsBYId(
			 @PathVariable("reviewId") long review_Id,@RequestBody Reviews review) throws Exception{
		 Reviews updatedDetails=Service.updateReviewAndRating(review_Id, review);
		 logger.info("Updating Reviews and Ratings !!");
		 if(updatedDetails==null) {
			throw new NoDataFoundException("No Such Data Found! ");		 
		 }
		 return new ResponseEntity<Reviews>(updatedDetails,HttpStatus.OK);
	 }
	 
	 @DeleteMapping("/{reviewId}")
	 public ResponseEntity<Reviews> cancelOrderById(@PathVariable("reviewId") long review_Id ){
		 Service.deleteReviewAndRating(review_Id);
		 logger.info("Deleting Reviews  ");
		 return new ResponseEntity<Reviews>(HttpStatus.NO_CONTENT);
	 }
}
