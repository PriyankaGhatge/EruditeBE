package com.niit.erudite.daoimp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.erudite.dao.ProductDao;
import com.niit.erudite.model.Category;
import com.niit.erudite.model.Product;
import com.niit.erudite.model.Supplier;

@Repository("ProductDao")
public class ProductDaoImp implements ProductDao{
	
	
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public void save(Product product) {
		sessionFactory.getCurrentSession().saveOrUpdate(product);
		
	}

	@Transactional
	public void update(Product product) {
		sessionFactory.getCurrentSession().update(product);
		
	}

	@Transactional
	public void delete(int id) {
		Product ProductToDelete = new Product();
		ProductToDelete.setProductid(id);
		sessionFactory.getCurrentSession().delete(ProductToDelete);
		
	}

	@Transactional
	public Product get(int productid) {
		return (Product) sessionFactory.getCurrentSession().get(Product.class, productid);
	}

	@Transactional
	public List<Product> list() {
		String hql = "from Product";
		Query query = sessionFactory.openSession().createQuery(hql);
		return query.list();
	}

	@Transactional
	public List<Category> listcategory_name() {
		String hql = "Select category_name from Category";
		Query query = sessionFactory.openSession().createQuery(hql);
		return query.list();
	}

	@Transactional
	public List<Supplier> listsupp_name() {
		String hql = "Select supp_name from Supplier";
		Query query = sessionFactory.openSession().createQuery(hql);
		return query.list();	
	}

}
