package com.ecom.ECommerce.models;

public class ProductDTO {
  
	private int id;
	private String name;
	private String description;
	private Integer price;
	private Integer quntyAvailable;
	
	public ProductDTO(String name, String description, Integer price, Integer quntyAvailable) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.quntyAvailable = quntyAvailable;
	}
	
	public ProductDTO(int id,String name, String description, Integer price, Integer quntyAvailable) {
		super();
		this.id=id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.quntyAvailable = quntyAvailable;
	}

	public ProductDTO() {
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
		return "ProductDTO [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", quntyAvailable=" + quntyAvailable + "]";
	}
}
