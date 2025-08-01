package com.example.cnkart.DAL;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.cnkart.entity.ItemReview;

import jakarta.persistence.EntityManager;

@Repository
public class ItemReviewIMP implements ItemReviewDALINT{

	
	@Autowired
	EntityManager entityManager;
	@Override
	public void save(ItemReview itemReview) {
	 Session session=	entityManager.unwrap(Session.class);
	 session.save(itemReview);
	}

}
