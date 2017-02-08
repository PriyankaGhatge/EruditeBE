package com.niit.erudite.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class Cart implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cart_id;
	
	@Column
	private int totalprice;
	
	@OneToOne
	@JoinColumn(name = "id")
	@JsonIgnore
	private UserCustomer usercustomer;
	
	

	public UserCustomer getUsercustomer() {
		return usercustomer;
	}

	public void setUsercustomer(UserCustomer usercustomer) {
		this.usercustomer = usercustomer;
	}

	@OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonIgnore
	private List<CartItem> cartitem;
	
	public int getCart_id() {
		return cart_id;
	}

	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}

	public int getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}
	
    public List<CartItem> getCartitems() {
		return cartitem;
	}

	public void setCartitems(List<CartItem> cartitem) {
		this.cartitem = cartitem;
	}

}
