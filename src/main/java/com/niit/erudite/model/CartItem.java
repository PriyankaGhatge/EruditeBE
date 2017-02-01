package com.niit.erudite.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class CartItem {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cartitem_id;

	@Column
	private int quantity;
	
	@Column
	private int totalprice;
	
	@ManyToOne
	@JoinColumn(name="productid")
	private Product product;
	
	@ManyToOne
	@JoinColumn(name="cart_id")
	@JsonIgnore
	private Cart cart;

	public int getCartitem_id() {
		return cartitem_id;
	}

	public void setCartitem_id(int cartitem_id) {
		this.cartitem_id = cartitem_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}
}
