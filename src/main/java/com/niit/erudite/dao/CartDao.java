package com.niit.erudite.dao;

import java.io.IOException;

import com.niit.erudite.model.Cart;

public interface CartDao {
	
	Cart getCartByCartId(int cart_id);
	Cart validate(int cart_id) throws IOException;
	void update(Cart cart);

}
