package com.ltimindtree;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import com.ltimindtree.Model.Restaurant;
import com.ltimindtree.Repository.Restaurant_Repository;
import com.ltimindtree.Service.RestaurantServiceImpl;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RestaurantMockitoUnit {

    public List<Restaurant> restaurants;
    
    @Mock
    Restaurant_Repository restaurant_repository;

    @InjectMocks
    RestaurantServiceImpl restaurant_service;

    @Test
    @Order(1)
    public void Test_findAllRestaurant(){
        List<Restaurant> restaurants=new ArrayList<Restaurant>();
        restaurants.add(new Restaurant(1L,"Taj","loke","dal chawal rajma",4.3,"bengaluru",1098,2,1));
        restaurants.add(new Restaurant(2L,"Bawarchi","Ghee","dal chicken rajma",4,"Hyderabad",12323,2,1));

        when(restaurant_repository.findAll())
                .thenReturn(restaurants);
        assertEquals(2,restaurant_service.findAllRestaurants().size());
    }

    @Test
    @Order(2)
    public void Test_addRestaurant(){
        Restaurant restaurant=new Restaurant
                (1L,"Taj","loke","dal chawal rajma",4.3,"bengaluru",1098,2,1);

        when(restaurant_repository.save(restaurant))
                .thenReturn(restaurant);
        assertEquals(restaurant,restaurant_service.saveRestaurantsDetails(restaurant));


    }
    

    @Test
    @Order(3)
    public void Test_deleteRestaurant(){
        Restaurant restaurant=new Restaurant(1L,"Taj","loke","dal chawal rajma",4.3,"bengaluru",1098,2,1);
        long restaurantId=2L;
        restaurant_service.deleteRestaurantById(restaurantId);
        verify(restaurant_repository,times(1)).deleteById(restaurantId);
    }
}
