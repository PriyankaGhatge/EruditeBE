package com.niit.erudite.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

	@Entity
	@Table
	@Component
	public class UserCustomer {
		
	@Id	
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
		
	private String username;
		
	private String password;
		
	private String contact;
		
	private String role;
		
	private String email;
		
		@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
		@JoinColumn(name = "billing_id")
		private BillingAddress billingAddress;

		

		@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
		@JoinColumn(name = "shipping_id")
		private ShippingAddress shippingAddress;
		
		@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
		@JoinColumn(name = "cart_id")
		@JsonIgnore
		private Cart cart;

		public Cart getCart() {
			return cart;
		}

		public void setCart(Cart cart) {
			this.cart = cart;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}
		
		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getContact() {
			return contact;
		}

		public void setContact(String contact) {
			this.contact = contact;
		}
		
		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}
		public BillingAddress getBillingAddress() {
			return billingAddress;
		}

		public void setBillingAddress(BillingAddress billingAddress) {
			this.billingAddress = billingAddress;
		}

		public ShippingAddress getShippingAddress() {
			return shippingAddress;
		}

		public void setShippingAddress(ShippingAddress shippingAddress) {
			this.shippingAddress = shippingAddress;
		}
	

	}


