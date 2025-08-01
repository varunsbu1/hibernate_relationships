package com.example.cnkart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cnkart.Service.ItemReviewService;
import com.example.cnkart.entity.ItemReview;

@RestController
@RequestMapping("/review")
public class ItemReviewController {

	
	@Autowired
	ItemReviewService itemReviewService;
	@PostMapping("/save")
	public void save(@RequestBody ItemReview itemReview) {
		itemReviewService.save(itemReview);
	}
}
