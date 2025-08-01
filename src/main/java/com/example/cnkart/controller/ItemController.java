package com.example.cnkart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cnkart.Service.ItemService;
import com.example.cnkart.entity.Item;

@RestController
@RequestMapping("/item")
public class ItemController {

	@Autowired
	ItemService itemService;
	
	
	@GetMapping("/id/{id}")
	public Item getItemById(@PathVariable int id) {
		return itemService.getItemById(id);
	}
//	
//	@GetMapping("/allItems")
//	public List<Item> getAllItems(){
//		return ItemService.getAllItems();
//	}
	
	@PostMapping("/save")
	public void saveItem(@RequestBody Item item) {
		
		itemService.saveItem(item);
	}
	
	
	@DeleteMapping("/remove/{id}")
	public void deleteItem(@PathVariable int id) {
		itemService.deleteItem(id);
	}
	
	@PutMapping("/update")
	public void updateItem(@RequestBody Item updateItem){
		//When you call the update method, Hibemate will synchronize the state of the persistent object with the database, updating
		//the database record to reflect any changes made to the object. For this to work, the object must already be associated with a
		//Hibernate session and have a corresponding database record.
		itemService.updateItem(updateItem);
	}
	
}
