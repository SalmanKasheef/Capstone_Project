package com.ltimindtree.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Review")
@Data @AllArgsConstructor @NoArgsConstructor

public class Reviews {

	public int getReview_id() {
		return review_id;
	}

	public void setReview_id(int review_id) {
		this.review_id = review_id;
	}

	public String getRestaurant_review() {
		return restaurant_review;
	}

	public void setRestaurant_review(String restaurant_review) {
		this.restaurant_review = restaurant_review;
	}

	public String getRestaurant_rating() {
		return restaurant_rating;
	}

	public void setRestaurant_rating(String restaurant_rating) {
		this.restaurant_rating = restaurant_rating;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int review_id;
	
	private String restaurant_review;
	
	private String restaurant_rating;
	
	
}
