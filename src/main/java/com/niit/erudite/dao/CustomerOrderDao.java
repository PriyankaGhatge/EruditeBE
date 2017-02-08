package com.niit.erudite.dao;

import com.niit.erudite.model.CustomerOrder;

public interface CustomerOrderDao {
	
	void addCustomerOrder(CustomerOrder order);
	int getCustomerOrderGrandTotal(int cart_id);

}
