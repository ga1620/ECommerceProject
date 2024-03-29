package com.ecom.ECommerce.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	private String description;
	private Integer price;
	private Integer quntyAvailable;
	
	public Product(String name, String description, Integer price, Integer quntyAvailable) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.quntyAvailable = quntyAvailable;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getQuntyAvailable() {
		return quntyAvailable;
	}

	public void setQuntyAvailable(Integer quntyAvailable) {
		this.quntyAvailable = quntyAvailable;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", quntyAvailable=" + quntyAvailable + "]";
	}
	
	
	
}
