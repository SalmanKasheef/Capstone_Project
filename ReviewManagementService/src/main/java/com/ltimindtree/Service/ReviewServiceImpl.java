package com.ltimindtree.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ltimindtree.Model.Reviews;
import com.ltimindtree.Repository.Review_Repository;

@Service
public class ReviewServiceImpl implements Review_Service {

	@Autowired
	private Review_Repository repository;
	
	@Override
	public List<Reviews> getAllReviewsofRestaurant() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Reviews getReviewsOfRestaurantById(long review_id) {
		// TODO Auto-generated method stub
		return repository.findById(review_id).get();
	}

	@Override
	public Reviews providereviewAndRatings(Reviews review) {
		// TODO Auto-generated method stub
		return repository.save(review);
	}

	@Override
	public Reviews updateReviewAndRating(long review_id, Reviews review) {
		Reviews updatedreviewAndrating=repository.findById(review_id).get();
			
			if(updatedreviewAndrating!=null) {
				updatedreviewAndrating.setRestaurant_rating(updatedreviewAndrating.getRestaurant_rating());
				updatedreviewAndrating.setRestaurant_review(updatedreviewAndrating.getRestaurant_rating());
			}
		return repository.save(updatedreviewAndrating);
	}

	@Override
	public void deleteReviewAndRating(long review_id) {
		// TODO Auto-generated method stub
		repository.deleteById(review_id);
	}

}
