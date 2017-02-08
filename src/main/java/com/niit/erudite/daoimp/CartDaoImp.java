package com.niit.erudite.daoimp;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.erudite.dao.CartDao;
import com.niit.erudite.dao.CustomerOrderDao;
import com.niit.erudite.model.Cart;

@Repository
@Transactional
public class CartDaoImp implements CartDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private CustomerOrderDao orderdao;

	@Autowired
	private CartDao cartdao;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public CartDao getCartdao() {
		return cartdao;
	}

	public void setCartdao(CartDao cartdao) {
		this.cartdao = cartdao;
	}


	@Transactional
	public Cart getCartByCartId(int cart_id) {
		Session session = sessionFactory.openSession();
		Cart cart = (Cart) session.get(Cart.class, cart_id);
		session.close();
		return cart;
	}

	
	public Cart validate(int cart_id) throws IOException {
		Cart cart = getCartByCartId(cart_id);
		System.out.println("Empty1");
		if (cart == null || cart.getCartitems().size() == 0) {
			throw new IOException(cart_id + "");
		}
		System.out.println("Empty2");
		update(cart);
		return cart;

	}

	
	public void update(Cart cart) {
		System.out.println("cart1");
		int cartId = cart.getCart_id();
		System.out.println("cart2");
		int grandTotal = orderdao.getCustomerOrderGrandTotal(cartId);
		cart.setTotalprice(grandTotal);

		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(cart);
		
	}

		
	

}
