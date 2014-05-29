package com.unicorn.mytime.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class BaseDaoImpl implements BaseDao {

	@Autowired
	private SessionFactory sessionFactory;

	
	public Session getCurrentSession() {
		Session session = null;
	    try { 
	        session = sessionFactory.getCurrentSession();
	    } catch ( HibernateException he ) {
	        session = sessionFactory.openSession();
	    }
	    return session;
	}
}
