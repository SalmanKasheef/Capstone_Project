package com.ltimindtree.Service;

import java.util.List;


import com.ltimindtree.Model.Restaurant_MenuItem;

public interface MenuItem_Service {

	List<Restaurant_MenuItem> listOfMenu();
	
	Restaurant_MenuItem findMenuById(long menu_id);
	
	Restaurant_MenuItem addNewMenu(Restaurant_MenuItem menu);
	
	Restaurant_MenuItem updateMenuById(long menu_id,Restaurant_MenuItem menu);
	
	void deleteMenuById(long menu_id);
	
}
