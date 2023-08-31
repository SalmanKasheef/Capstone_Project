package com.ltimindtree;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ltimindtree.Model.Restaurant;
import com.ltimindtree.Repository.Restaurant_Repository;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class RestaurantSearchServiceApplicationTests {

	@Test
	void contextLoads() {
	}

	

	@Autowired
	Restaurant_Repository restaurant_repository;

	@Test
	@Order(1)
	public void testCreate(){
		Restaurant restaurant=new Restaurant();
		restaurant.setRestaurant_Id(1L);
		restaurant.setMenu_Of_restaurant("Rajma Chicken");
		restaurant.setRestaurant_Name("Taj Hotel");
		restaurant.setBudget(5000);
		restaurant.setCuisine("Chicken");
		restaurant.setDistance(7);
		restaurant.setRatings(4);
		restaurant_repository.save(restaurant);
		assertNotNull(restaurant_repository.findById(1L).get());
	}

	@Test
	@Order(2)
	public void testRealAll(){
		List list=restaurant_repository.findAll();
		assertThat(list).size().isGreaterThan(0);
	}

	@Test
	@Order(3)
	public void testRead(){
		Restaurant restaurant=restaurant_repository.findById(1L).get();
		assertEquals("Taj Hotel",restaurant.getRestaurant_Name());
	}

	@Test
	@Order(4)
	public void testUpdate(){
		Restaurant restaurant=restaurant_repository.findById(1L).get();
		restaurant.setBudget(9000);
		restaurant_repository.save(restaurant);
		assertNotEquals(8000,restaurant_repository.findById(1L)
				.get().getBudget());
	}

	@Test
	@Order(5)
	public void testDelete(){
		restaurant_repository.deleteById(1L);
		assertThat(restaurant_repository.existsById(1L)).isFalse();
	}
}
