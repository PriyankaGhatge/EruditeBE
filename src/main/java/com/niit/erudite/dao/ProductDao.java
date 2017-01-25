package com.niit.erudite.dao;

import java.util.List;

import com.niit.erudite.model.Category;
import com.niit.erudite.model.Product;
import com.niit.erudite.model.Supplier;

public interface ProductDao {

	public void save(Product product);

	public void update(Product product);

	public void delete(int id);

	public Product get(int product_id);

	public List<Product> list();
	
	public List<Category>listcategory_name();
	
	public List<Supplier>listsupp_name();
	
	
}
