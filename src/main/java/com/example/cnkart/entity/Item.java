package com.example.cnkart.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "item")
public class Item {// itemDetails in Item ------ To navigate from Item → ItemDetails

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int id;
	@Column
	private String name;
	@Column
	private String description;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "item_details_id")
	private ItemDetails itemDetails;

	public List<ItemReview> getItemReview() {
		return itemReview;
	}

	public void setItemReview(List<ItemReview> itemReview) {
		this.itemReview = itemReview;
	}

	// mapped by field of item in itemReview
	@OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
	@JsonManagedReference

	private List<ItemReview> itemReview;

	@ManyToMany(mappedBy = "items", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Order> orders;

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ItemDetails getItemDetails() {
		return itemDetails;
	}

	public void setItemDetails(ItemDetails itemDetails) {
		this.itemDetails = itemDetails;
	}

}
