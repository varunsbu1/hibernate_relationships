package com.example.cnkart.DAL;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.cnkart.entity.ItemDetails;

import jakarta.persistence.EntityManager;

@Repository
public class ItemDetailsDALIMP implements ItemDetailsDALINT {
	
	
	@Autowired
	EntityManager entityManager;

	@Override
	public void delete(int id) {
		Session session=entityManager.unwrap(Session.class);
	ItemDetails  itemDetails=	session.get(ItemDetails.class, id);
	session.delete(itemDetails);
	}

}
