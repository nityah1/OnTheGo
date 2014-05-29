package com.unicorn.mytime.dao;

import org.hibernate.Session;

import com.unicorn.mytime.model.Employee;

public interface BaseDao {

	public Session getCurrentSession();

}
