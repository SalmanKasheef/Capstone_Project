package com.ltimindtree;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ltimindtree.Model.Reviews;
import com.ltimindtree.Repository.Review_Repository;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder( MethodOrderer.OrderAnnotation.class)
class ReviewManagementServiceApplicationTests {

	@Test
	void contextLoads() {
	}
//
//	@Autowired
//	Review_Repository review_repository;
//
//
//	@Test
//	@Order(1)
//	public void testCreate(){
//		Reviews reviews =new Reviews();
//		reviews.setReview_id(1);
//		reviews.setRestaurant_review("Very Good");
//		reviews.setRestaurant_rating("5 Star");
//		review_repository.save(reviews);
//		assertNotNull(review_repository.findById(1l).get());
//	}
//
//	@Test
//	@Order(2)
//	public void testRealAll(){
//		List list=review_repository.findAll();
//		assertThat(list).size().isGreaterThan(0);
//	}
//
//	@Test
//	@Order(3)
//	public void testRead(){
//		Reviews reviews=review_repository.findById(1L).get();
//		assertEquals("Very Good",reviews.getRestaurant_review());
//	}
//
//	@Test
//	@Order(4)
//	public void testUpdate(){
//		Reviews reviews=review_repository.findById(1L).get();
//		reviews.setRestaurant_rating("4 star");
//		review_repository.save(reviews);
//		assertNotEquals("3 star",review_repository.findById(1L)
//				.get().getRestaurant_rating());
//	}
//
//	@Test
//	@Order(5)
//	public void testDelete(){
//		review_repository.deleteById(1L);
//		assertThat(review_repository.existsById(1L)).isFalse();
//	}
}
