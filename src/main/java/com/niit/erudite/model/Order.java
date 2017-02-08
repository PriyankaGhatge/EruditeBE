package com.niit.erudite.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Order implements Serializable {

		private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int order_id;
	
	@OneToOne
	@JoinColumn(name="cart_id")
	private Cart cart;
	
	@OneToOne
	@JoinColumn(name="id")
	private UserCustomer user; //doubt
	
	@OneToOne
	@JoinColumn(name="billing_id")
	private BillingAddress billingAddress;
	
	@OneToOne
	@JoinColumn(name="shipping_id")
	private ShippingAddress shippingAddress;
	
	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public UserCustomer getUser() {
		return user;
	}

	public void setUser(UserCustomer user) {
		this.user = user;
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
