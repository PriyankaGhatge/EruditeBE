package com.niit.erudite.daoimp;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.erudite.dao.UserDao;
import com.niit.erudite.model.Cart;
import com.niit.erudite.model.UserCustomer;

@SuppressWarnings("deprecation")
@Transactional
@Repository("UserDao")
public class UserDaoImp implements UserDao{
	
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public UserCustomer get(String username) {

		Session session = this.sessionFactory.openSession();
		Query query = session.createQuery("from UserCustomer where username=?");
		query.setString(0, username);
		UserCustomer user = (UserCustomer) query.uniqueResult();
		// logger.info("USer loaded successfully, User details="+User);
		// session.flush();
		// session.close();
		return user;

	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<UserCustomer> list() {

		String hql = "from User";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

	
	@Transactional
	public UserCustomer get(int id) {
				return (UserCustomer) sessionFactory.getCurrentSession().get(UserCustomer.class, id);
	}
	

	@Transactional
	public UserCustomer validate(String id, String password) {
		System.out.println("inside validate");
		String hql = "from User where id ='" + id + "'  and password='" + password + "'";
		System.out.println("After hql");
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		System.out.println("after query");
		return (UserCustomer) query.uniqueResult();

	}
	
	@Transactional
	public void save(UserCustomer user) {

			System.out.println("save user");	
			/*sessionFactory.getCurrentSession().saveOrUpdate(user);*/
			Session session = sessionFactory.getCurrentSession();
			user.setRole("ROLE_ADMIN");
			/*user.setRole("ROLE_USER");*/
			
			Cart cart = new Cart();
			user.setCart(cart);
			cart.setUserCustomer(user);
			session.saveOrUpdate(user);
		}
	
	@Transactional
	public boolean update(UserCustomer user) {
		try {
			sessionFactory.getCurrentSession().update(user);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}


	