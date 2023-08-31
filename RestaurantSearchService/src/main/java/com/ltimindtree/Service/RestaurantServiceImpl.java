package com.ltimindtree.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ltimindtree.Model.Restaurant;
import com.ltimindtree.Repository.Restaurant_Repository;
import com.ltimindtree.VO.Orders;
import com.ltimindtree.VO.ResponseTemplateVO;

@Service
public class RestaurantServiceImpl implements Restaurant_Service {

	@Autowired
	private Restaurant_Repository repository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public List<Restaurant> findAllRestaurants() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Restaurant findRestaurantsById(long restaurant_id) {
		// TODO Auto-generated method stub

		return repository.findById(restaurant_id).get();
		
	}


	@Override
	public Restaurant saveRestaurantsDetails(Restaurant restaurant) {
		// TODO Auto-generated method stub
		return repository.save(restaurant);
	}

	@Override
	public Restaurant updateRestaurantById(long restaurant_id, Restaurant restaurant) {
	Restaurant updatedDetails=repository.findById(restaurant_id).get();
		
		if(updatedDetails!=null) {
			
			updatedDetails.setRestaurant_Name(updatedDetails.getRestaurant_Name());
			updatedDetails.setDistance(updatedDetails.getDistance());
			updatedDetails.setLocation(updatedDetails.getLocation());
			updatedDetails.setCuisine(updatedDetails.getCuisine());
			updatedDetails.setBudget(updatedDetails.getBudget());
			updatedDetails.setRatings(updatedDetails.getRatings());
			updatedDetails.setMenu_Of_restaurant(updatedDetails.getMenu_Of_restaurant());
		}
		return repository.save(updatedDetails);
	}

	@Override
	public void deleteRestaurantById(long restaurant_id) {
		repository.deleteById(restaurant_id);

	}

	//Implementing RestTemplate
	@Override
	public ResponseTemplateVO getRestaurantsWithOrders(long restaurant_id) {
		ResponseTemplateVO Vo=new ResponseTemplateVO();
		
		Restaurant restaurant=repository.findById(restaurant_id).get();
		
		Orders order=restTemplate.getForObject("http://localhost:8081/api/orders/"+restaurant.getOrder_id()
						, Orders.class);
		
		Vo.setOrder(order);
		Vo.setRestaurant(restaurant);
		
		return Vo;
	}

	

}
