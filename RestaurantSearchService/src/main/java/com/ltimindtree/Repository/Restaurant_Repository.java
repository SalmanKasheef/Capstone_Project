package com.ltimindtree.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ltimindtree.Model.Restaurant;

@Repository
public interface Restaurant_Repository extends JpaRepository<Restaurant,Long>{

//	Optional<Restaurant> findByName(String restaurant_name);
//
//	Optional<Restaurant> findByCuisine(String restaurant_cuisine);
//
//	Optional<Restaurant> findByRating(String restaurant_ratings);

}
