package com.example.cnkart.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cnkart.DAL.ItemReviewDALINT;
import com.example.cnkart.entity.ItemReview;

import jakarta.transaction.Transactional;

@Service
public class ItemReviewService {

	@Autowired
	ItemReviewDALINT itemReviewDALINT;
	
	@Transactional
	public void save(ItemReview itemReview) {
		itemReviewDALINT.save(itemReview);
	}

	
}
