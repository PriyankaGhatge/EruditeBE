package com.niit.erudite.dao;

import com.niit.erudite.model.Order;

public interface OrderDao {
	
	void addCustomerOrder(Order order);
	int getCustomerOrderGrandTotal(int cart_id);

}
