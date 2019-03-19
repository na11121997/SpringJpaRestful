package com.cg.product.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
//Entity Bean Class
@Entity	//table is create for the class with the annotation @Entity
public class Product {
	@Id		//Primary Key is create for the variable with the annotation @Id
	private String id;
	private String name;
	private String model;
	private int price;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", model=" + model + ", price=" + price + "]";
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(String id, String name, String model, int price) {
		super();
		this.id = id;
		this.name = name;
		this.model = model;
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

}
