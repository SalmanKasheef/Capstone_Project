package com.ltimindtree.Model;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Table(name="restaurants")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Restaurant {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Restaurant_Id;
	
	@NotNull(message="Name Cannot be Null")
	private String Restaurant_Name;
	
	private String Cuisine;
	
	private String Menu_Of_restaurant;
	
	@PositiveOrZero
	private double Distance;
	
	private String Location;
	
	private int Budget;
	
	private double Ratings;
	
	private long order_id;

	@OneToMany
	@JoinColumn(name="menu_id")
	private List<Restaurant_MenuItem> menuItem;
	
	public Restaurant() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Long getRestaurant_Id() {
		return Restaurant_Id;
	}



	public void setRestaurant_Id(Long restaurant_Id) {
		Restaurant_Id = restaurant_Id;
	}



	public String getRestaurant_Name() {
		return Restaurant_Name;
	}



	public void setRestaurant_Name(String restaurant_Name) {
		Restaurant_Name = restaurant_Name;
	}



	public String getCuisine() {
		return Cuisine;
	}



	public void setCuisine(String cuisine) {
		Cuisine = cuisine;
	}



	public String getMenu_Of_restaurant() {
		return Menu_Of_restaurant;
	}



	public void setMenu_Of_restaurant(String menu_Of_restaurant) {
		Menu_Of_restaurant = menu_Of_restaurant;
	}



	public double getDistance() {
		return Distance;
	}



	public void setDistance(double distance) {
		Distance = distance;
	}



	public String getLocation() {
		return Location;
	}



	public void setLocation(String location) {
		Location = location;
	}



	public int getBudget() {
		return Budget;
	}



	public void setBudget(int budget) {
		Budget = budget;
	}



	public double getRatings() {
		return Ratings;
	}



	public void setRatings(double ratings) {
		Ratings = ratings;
	}



	public long getOrder_id() {
		return order_id;
	}



	public void setOrder_id(long order_id) {
		this.order_id = order_id;
	}



	public Restaurant(Long restaurant_Id, @NotNull(message = "Name Cannot be Null") String restaurant_Name,
			String cuisine, String menu_Of_restaurant, @PositiveOrZero double distance, String location, int budget,
			double ratings, long order_id) {
		super();
		Restaurant_Id = restaurant_Id;
		Restaurant_Name = restaurant_Name;
		Cuisine = cuisine;
		Menu_Of_restaurant = menu_Of_restaurant;
		Distance = distance;
		Location = location;
		Budget = budget;
		Ratings = ratings;
		this.order_id = order_id;
	}



	@Override
	public String toString() {
		return "Restaurant [Restaurant_Id=" + Restaurant_Id + ", Restaurant_Name=" + Restaurant_Name + ", Cuisine="
				+ Cuisine + ", Menu_Of_restaurant=" + Menu_Of_restaurant + ", Distance=" + Distance + ", Location="
				+ Location + ", Budget=" + Budget + ", Ratings=" + Ratings + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(Budget, Cuisine, Distance, Location, Menu_Of_restaurant, Ratings, Restaurant_Id,
				Restaurant_Name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Restaurant other = (Restaurant) obj;
		return Budget == other.Budget && Objects.equals(Cuisine, other.Cuisine)
				&& Double.doubleToLongBits(Distance) == Double.doubleToLongBits(other.Distance)
				&& Objects.equals(Location, other.Location)
				&& Objects.equals(Menu_Of_restaurant, other.Menu_Of_restaurant)
				&& Double.doubleToLongBits(Ratings) == Double.doubleToLongBits(other.Ratings)
				&& Objects.equals(Restaurant_Id, other.Restaurant_Id)
				&& Objects.equals(Restaurant_Name, other.Restaurant_Name);
	}

	
}
