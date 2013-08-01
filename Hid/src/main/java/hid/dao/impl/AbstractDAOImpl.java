package hid.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import hid.dao.AbstractDAO;
import hid.entity.java.Person;

public class AbstractDAOImpl<E> implements AbstractDAO<E> {
	
	private Class<E> entityClass;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	protected AbstractDAOImpl(Class<E> entityClass) {
		this.entityClass = entityClass;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public E findById(long id) {
		return (E) getCurrentSession().get(entityClass, id);
	}

	@Override
	public void saveOrUpdate(E entity) {
		getCurrentSession().saveOrUpdate(entity);		
	}

	@Override
	public void delete(long id) {
		Person person = (Person) getCurrentSession().get(entityClass, id);
		getCurrentSession().delete(person);
	}
	
	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

}
