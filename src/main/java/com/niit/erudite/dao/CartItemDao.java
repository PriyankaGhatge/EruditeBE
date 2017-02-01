package com.niit.erudite.dao;

import com.niit.erudite.model.Cart;
import com.niit.erudite.model.CartItem;

public interface CartItemDao {
	
	void addCartItem(CartItem cartitem);
	void removeCartItem(int cartitem_id);
	void removeAllCartItems(Cart cart);

}
