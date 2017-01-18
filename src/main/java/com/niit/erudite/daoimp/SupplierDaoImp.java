package com.niit.erudite.daoimp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.erudite.dao.SupplierDao;
import com.niit.erudite.model.Category;
import com.niit.erudite.model.Supplier;

@Repository("SupplierDao")
public class SupplierDaoImp implements SupplierDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public List<Supplier> list() {
		  String hql = "from Supplier";
		  Query query = sessionFactory.getCurrentSession().createQuery(hql);
		  return query.list();
		
	}

	@Transactional
	public Supplier get(int supp_id) {
		
		 return (Supplier) sessionFactory.getCurrentSession().get(Supplier.class, supp_id);
	}

	@Transactional
	public void save(Supplier supplier) {
		
		sessionFactory.getCurrentSession().saveOrUpdate(supplier);
	}

	@Transactional
	public void update(Supplier supplier) {
		
		sessionFactory.getCurrentSession().update(supplier);	
	}

	@Transactional
	public void delete(int supp_id) {
		Supplier SupplierToDelete = new Supplier();
		SupplierToDelete.setSupp_id(supp_id);
		sessionFactory.getCurrentSession().delete(SupplierToDelete);
			
	
	}

}
