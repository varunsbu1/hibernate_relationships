package com.example.cnkart.DAL;

import com.example.cnkart.entity.Item;

public interface ItemDALInterface {

	Item getById(int id);
	
	void save(Item item);
	
	//List<Item> getAllItems()
	
	void delete(int id);
	
	void update(Item updateItem);
}
