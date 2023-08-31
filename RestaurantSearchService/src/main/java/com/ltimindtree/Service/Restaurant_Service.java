package com.ltimindtree.Service;

import java.util.List;

import com.ltimindtree.Model.Restaurant;
import com.ltimindtree.VO.ResponseTemplateVO;

public interface Restaurant_Service {

	List<Restaurant> findAllRestaurants();
	
	Restaurant findRestaurantsById(long restaurant_id);
	
	Restaurant saveRestaurantsDetails(Restaurant restaurant);
	
	Restaurant updateRestaurantById(long restaurant_id,Restaurant restaurant);
	
	void deleteRestaurantById(long restaurant_id);
	
	ResponseTemplateVO getRestaurantsWithOrders(long restaurant_id);
}
