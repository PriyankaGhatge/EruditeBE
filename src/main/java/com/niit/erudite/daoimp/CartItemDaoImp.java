package com.niit.erudite.daoimp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.erudite.dao.CartItemDao;
import com.niit.erudite.model.Cart;
import com.niit.erudite.model.CartItem;

@Repository
@Transactional
public class CartItemDaoImp implements CartItemDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void addCartItem(CartItem cartitem) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(cartitem);
		
	}

	@Transactional
	public void removeCartItem(int cartitem_id) {
		Session session = sessionFactory.getCurrentSession();
		CartItem cartItem = (CartItem) session.get(CartItem.class, cartitem_id); //cartItem-doubt
		session.delete(cartItem);

		Cart cart = cartItem.getCart();
		List<CartItem> cartItems = cart.getCartitem();
		cartItems.remove(cartItem);
		
	}

	@Transactional
	public void removeAllCartItems(Cart cart) {
		List<CartItem> cartItems = cart.getCartitem();
		for (CartItem cartItem : cartItems) {
			removeCartItem(cartItem.getCartitem_id());
	}

	}	
	
}
