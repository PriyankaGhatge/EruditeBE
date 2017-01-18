package com.niit.erudite.dao;

import java.util.List;

import com.niit.erudite.model.Supplier;

public interface SupplierDao {
	
	public List<Supplier> list();
	
	public Supplier get(int supp_id);
	
	public void save(Supplier supplier);
	 
	public void update(Supplier supplier);
	 
	public void delete(int supp_id);
	
	
	
}
