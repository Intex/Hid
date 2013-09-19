package com.intexsoft.sensor.dao.impl;

import com.intexsoft.sensor.dao.AbstractDAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

public class AbstractDAOImpl<E> implements AbstractDAO<E> {

	private Class<E> entityClass;

	@Autowired
	private SessionFactory sessionFactory;

	protected AbstractDAOImpl(Class<E> entityClass) {		
		this.entityClass = entityClass;
	}

	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	@SuppressWarnings("unchecked")
	public E findById(long id) {
		return (E) getCurrentSession().get(entityClass, id);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<E> getAll() {
		return getCurrentSession().createCriteria(entityClass.getName()).list();
	}

	@Override
	public void saveOrUpdate(E entity) {
		getCurrentSession().saveOrUpdate(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void delete(long id) {
		E entity = (E) getCurrentSession().get(entityClass, id);
		getCurrentSession().delete(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<E> findByProperty(String propertyName, Object propertyValue) {
		Criterion criterion = Restrictions.eq(propertyName, propertyValue);
		return getCurrentSession().createCriteria(entityClass).add(criterion).list();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E findUniqueByProperty(String propertyName, Object propertyValue) {
		Criterion criterion = Restrictions.eq(propertyName, propertyValue);
		return (E) getCurrentSession().createCriteria(entityClass).add(criterion).uniqueResult();
	}
}
