package com.example.cnkart.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cnkart.DAL.ItemDALInterface;
import com.example.cnkart.DAL.OrderDAL;
import com.example.cnkart.entity.Item;
import com.example.cnkart.entity.Order;

import jakarta.transaction.Transactional;

@Service
public class OrderService {
	
	@Autowired
	OrderDAL orderDAL;
	
	@Autowired
	ItemDALInterface itemDALInterface;
	
	@Transactional
	public Order getOrderById(int id) {
		return orderDAL.getOrderById(id);

	}

	@Transactional
	public void saveOrder(Order order) {
		Order saveOrder=new Order();
		saveOrder.setOrderType(order.getOrderType());
		
		List<Item>itemList=new ArrayList<>();
		for(Item item:order.getItems()) {
			Item currentItem=itemDALInterface.getById(item.getId());
			itemList.add(currentItem);
		}
		saveOrder.setItems(itemList);
		
		orderDAL.save(saveOrder);
	}

	@Transactional
	public void delete(int id) {
		orderDAL.delete(id);
		
	}

}
