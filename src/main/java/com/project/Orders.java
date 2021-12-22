package com.project;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
	 
	@Entity
	@Table(name="orders")
	public class Orders {
		@Id 
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long Id;
		
		@Column(nullable = false)
		private String ordered_week;
		
		@Column(nullable = false)
	    private String orderDetail;
		
		public Orders() {}
		
		@ManyToOne
		@JoinColumn(name="product_id")
		private Product product;
		
		@ManyToOne
		@JoinColumn(name="customer_id")
		private Customer customer;

		public long getId() {
			return Id;
		}

		public void setId(long id) {
			Id = id;
		}

		public String getOrdered_week() {
			return ordered_week;
		}

		public void setOrdered_week(String ordered_week) {
			this.ordered_week = ordered_week;
		}

		public String getOrderDetail() {
			return orderDetail;
		}

		public void setOrderDetail(String orderDetail) {
			this.orderDetail = orderDetail;
		}

		public Product getProduct() {
			return product;
		}

		public void setProduct(Product product) {
			this.product = product;
		}

		public Customer getCustomer() {
			return customer;
		}

		public void setCustomer(Customer customer) {
			this.customer = customer;
		}
}