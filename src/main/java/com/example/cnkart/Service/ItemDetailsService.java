package com.example.cnkart.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cnkart.DAL.ItemDetailsDALINT;

import jakarta.transaction.Transactional;

@Service
public class ItemDetailsService {
	
	@Autowired
	ItemDetailsDALINT itemDetailsDALINT;

	@Transactional
	public void delete(int id) {
		itemDetailsDALINT.delete(id);
	}

}
