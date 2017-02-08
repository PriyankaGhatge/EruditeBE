package com.niit.erudite.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Component
@Table
@Entity
public class ShippingAddress implements Serializable  {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int shipping_id;

	@Column
	private String country;	
	
	@Column
	private String state;	
	
	@Column
	private String city;
	
	@Column
	private String zipcode;
	
	@Column
	private String addressline1;
	
	@Column
	private String addressline2;
	
	@OneToOne(mappedBy = "shippingAddress")
	@JsonIgnore
	private UserCustomer user;
	
	public UserCustomer getUser() {
		return user;
	}

	public void setUser(UserCustomer user) {
		this.user = user;
	}

	public int getShipping_id() {
		return shipping_id;
	}

	public void setShipping_id(int shipping_id) {
		this.shipping_id = shipping_id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getAddressline1() {
		return addressline1;
	}

	public void setAddressline1(String addressline1) {
		this.addressline1 = addressline1;
	}

	public String getAddressline2() {
		return addressline2;
	}

	public void setAddressline2(String addressline2) {
		this.addressline2 = addressline2;
	}

}
