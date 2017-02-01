package com.niit.erudite.dao;

import java.util.List;

import com.niit.erudite.model.UserCustomer;

public interface UserDao {

	public List<UserCustomer> list();

	public UserCustomer get(int id);

	public UserCustomer validate(String id, String password);

	public void save(UserCustomer user);
	
	public UserCustomer get(String username);

	public boolean update(UserCustomer user);

}

	