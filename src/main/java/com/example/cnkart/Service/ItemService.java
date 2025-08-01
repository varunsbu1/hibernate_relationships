package com.example.cnkart.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cnkart.DAL.ItemDALInterface;
import com.example.cnkart.entity.Item;

import jakarta.transaction.Transactional;

@Service
public class ItemService {

	@Autowired
	ItemDALInterface itemDALInterface;
	
	@Transactional
	public Item getItemById(int id) {
		return itemDALInterface.getById(id);
	}

	@Transactional
	public void saveItem(Item item) {
		itemDALInterface.save(item);
	}

	@Transactional
	public void deleteItem(int id) {
		itemDALInterface.delete(id);
	}

	@Transactional
	public void updateItem(Item updateItem) {
		//When you call the update method, Hibemate will synchronize the state of the persistent object with the database, updating
				//the database record to reflect any changes made to the object. For this to work, the object must already be associated with a
				//Hibernate session and have a corresponding database record.
		itemDALInterface.update(updateItem);
	}

//	@Transactional
//	public static List<Item> getAllItems() {
//		return itemDALInterfa
//	}
}
