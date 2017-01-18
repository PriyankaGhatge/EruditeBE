package com.niit.erudite.dao;

import java.util.List;

import com.niit.erudite.model.Category;

public interface CategoryDao {
	
	 public List<Category> list();
	 
	 public Category get(int category_id);

	 public void save(Category category);
	 
	 public void update(Category category);
	 
	 public void delete(int category_id);


}
