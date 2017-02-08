package com.niit.erudite.daoimp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.erudite.dao.CartDao;
import com.niit.erudite.dao.OrderDao;
import com.niit.erudite.model.Cart;
import com.niit.erudite.model.CartItem;
import com.niit.erudite.model.Order;

@Transactional
@Repository
public class OrderDaoImp implements OrderDao {
	
	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	CartDao cartdao;

	@Autowired
	OrderDao orderdao;
	

	@Transactional
	public void addCustomerOrder(Order order) {
		System.out.println("hello customer table ");
		Session session = sessionFactory.getCurrentSession();
		System.out.println("cust1");
		session.saveOrUpdate(order);
		System.out.println("cust2");
		
	}

	@Transactional
	public int getCustomerOrderGrandTotal(int cart_id) {
		int grandTotal = 0;
		System.out.println("cust71 :" +cartdao.getCartByCartId(cart_id));
		Cart cart = cartdao.getCartByCartId(cart_id);
		List<CartItem> cartitems= cart.getCartitems();
		System.out.println("cust81");
		for (CartItem item : cartitems) {
			grandTotal += item.getTotalprice();
		}
		System.out.println("cust91");
		return grandTotal;	
	}

}
