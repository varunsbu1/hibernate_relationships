package com.example.cnkart.DAL;

import com.example.cnkart.entity.Order;

public interface OrderDAL {

	Order getOrderById(int id);
	
	void delete(int id);
	
	void save(Order saveOrder);
}
