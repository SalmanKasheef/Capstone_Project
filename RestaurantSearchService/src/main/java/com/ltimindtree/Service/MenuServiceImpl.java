package com.ltimindtree.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ltimindtree.Model.Restaurant_MenuItem;
import com.ltimindtree.Repository.Menu_Item;

@Service
public class MenuServiceImpl implements MenuItem_Service {

	
	@Autowired
	private Menu_Item repository;
	
	
	@Override
	public List<Restaurant_MenuItem> listOfMenu() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Restaurant_MenuItem findMenuById(long menu_id) {
		// TODO Auto-generated method stub
		return repository.findById(menu_id).get();
	}

	@Override
	public Restaurant_MenuItem addNewMenu(Restaurant_MenuItem menu) {
		// TODO Auto-generated method stub
		return repository.save(menu);
	}

	@Override
	public Restaurant_MenuItem updateMenuById(long menu_id, Restaurant_MenuItem menu) {
		Restaurant_MenuItem updatedMenu=repository.findById(menu_id).get();
				if(updatedMenu!=null) {
					updatedMenu.setName(updatedMenu.getName());
					updatedMenu.setDescription(updatedMenu.getDescription());
					updatedMenu.setPrice(updatedMenu.getPrice());
				}
				return repository.save(updatedMenu);
	}

	@Override
	public void deleteMenuById(long menu_id) {
		// TODO Auto-generated method stub
		repository.deleteById(menu_id);
	}

}
