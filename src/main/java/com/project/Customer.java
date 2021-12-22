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
	@Table(name="customer")
	public class Customer {
		@Id 
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
	    private String firstname;
	    private String lastname;
	    private String email;	
	    private String country;	
	    
	    @OneToMany(mappedBy="customer", cascade=CascadeType.ALL)
	    private Set<Orders>orders=new HashSet<>();
	    
	    public Customer() {}

		public Long getId() {
			return id;
		}
		

		public void setId(Long id) {
			this.id = id;
		}

		public String getFirstname() {
			return firstname;
		}

		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}

		public String getLastname() {
			return lastname;
		}

		public void setLastname(String lastname) {
			this.lastname = lastname;
		}
		

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		public Set<Orders> getOrders() {
			return orders;
		}

		public void setOrders(Set<Orders> orders) {
			this.orders = orders;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}    
	}
	