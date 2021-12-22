package com.project;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
	 
	@Entity
	@Table(name="product")
	public class Product {
		@Id 
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
	    private String category;
	    private String brand;
	    private String name;
	    private String color;
	    private float size;
	    private float price;
	    	    
	    @OneToMany(mappedBy="product", cascade=CascadeType.ALL, orphanRemoval=true)
	    private Set<Orders>orders=new HashSet<>();

		public Product() {}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getCategory() {
			return category;
		}

		public void setCategory(String category) {
			this.category = category;
		}

		public String getBrand() {
			return brand;
		}

		public void setBrand(String brand) {
			this.brand = brand;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getColor() {
			return color;
		}

		public void setColor(String color) {
			this.color = color;
		}

		public float getSize() {
			return size;
		}

		public void setSize(float size) {
			this.size = size;
		}

		public float getPrice() {
			return price;
		}

		public void setPrice(float price) {
			this.price = price;
		}

		@Override
		public String toString() {
			return "Product [id=" + id + ", category=" + category + ", brand=" + brand + ", name=" + name + ", color="
					+ color + ", size=" + size + ", price=" + price + "]";
		}
	}