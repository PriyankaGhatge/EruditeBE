package com.niit.erudite.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component

public class Supplier {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int supp_id;
	
	private String supp_name;
	
	private String supp_address;


	public int getSupp_id() {
		return supp_id;
	}

	public void setSupp_id(int supp_id) {
		this.supp_id = supp_id;
	}

	public String getSupp_name() {
		return supp_name;
	}

	public void setSupp_name(String supp_name) {
		this.supp_name = supp_name;
	}

	public String getSupp_address() {
		return supp_address;
	}

	public void setSupp_address(String supp_address) {
		this.supp_address = supp_address;
	}
	
}
