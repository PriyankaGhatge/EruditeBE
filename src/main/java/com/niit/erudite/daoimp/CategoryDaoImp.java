package com.niit.erudite.daoimp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.erudite.dao.CategoryDao;
import com.niit.erudite.model.Category;

@Repository("CategoryDao")
public class CategoryDaoImp implements CategoryDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Transactional
	public List<Category> list() {
		
	  String hql = "from Category";
	  Query query = sessionFactory.getCurrentSession().createQuery(hql);
	  return query.list();
	}
	
 
	@Transactional
	public Category get(int category_id) {
	
	 return (Category) sessionFactory.getCurrentSession().get(Category.class, category_id);
	}

	@Transactional
	public void save(Category category) {
		sessionFactory.getCurrentSession().saveOrUpdate(category);	
		}

	@Transactional
	public void update(Category category) {
		sessionFactory.getCurrentSession().update(category);
		}

	@Transactional
	public void delete(int category_id) {
		Category CategoryToDelete = new Category();
		CategoryToDelete.setCategory_id(category_id);
		sessionFactory.getCurrentSession().delete(CategoryToDelete);
		
	}

}
