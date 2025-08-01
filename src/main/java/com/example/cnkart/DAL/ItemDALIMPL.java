package com.example.cnkart.DAL;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.cnkart.entity.Item;

import jakarta.persistence.EntityManager;


@Repository
public class ItemDALIMPL implements ItemDALInterface {
	
	@Autowired
	EntityManager entityManager;

	@Override
	public Item getById(int id) {
		Session session=entityManager.unwrap(Session.class);
		Item item= session.get(Item.class, id);//fetch the item based on id from the database
		return item;
	}

	@Override
	public void save(Item item) {
		Session session = entityManager.unwrap(Session.class);
		session.save(item);
	}

	@Override
	public void delete(int id) {
		Session session=entityManager.unwrap(Session.class);
		//void delete(Object object);
		//thats why we created the item object
		Item item=session.get(Item.class, id);
		session.delete(item);//
	}

	@Override
	public void update(Item updateItem) {
		//When you call the update method, Hibemate will synchronize the state of the persistent object with the database, updating
				//the database record to reflect any changes made to the object. For this to work, the object must already be associated with a
				//Hibernate session and have a corresponding database record.
		Session session=entityManager.unwrap(Session.class);
		Item currentItem=session.get(Item.class,updateItem.getId() );
		currentItem.setDescription(updateItem.getDescription());
		currentItem.setName(updateItem.getName());
		session.update(currentItem);
	}

}
