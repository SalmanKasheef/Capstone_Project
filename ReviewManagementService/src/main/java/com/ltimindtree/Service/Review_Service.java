package com.ltimindtree.Service;

import java.util.List;

import com.ltimindtree.Model.Reviews;


public interface Review_Service {


	List<Reviews> getAllReviewsofRestaurant();
	
	Reviews getReviewsOfRestaurantById(long review_id);
	
	Reviews providereviewAndRatings(Reviews review);
	
	Reviews updateReviewAndRating(long review_id,Reviews review);
	
	void deleteReviewAndRating(long review_id);

	
}
