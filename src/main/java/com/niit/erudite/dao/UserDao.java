package com.niit.erudite.dao;

import java.util.List;

import com.niit.erudite.model.User;

public interface UserDao {

	public List<User> list();

	public User get(int id);

	public User validate(String id, String password);

	public void save(User user);

	public boolean update(User user);

}

	