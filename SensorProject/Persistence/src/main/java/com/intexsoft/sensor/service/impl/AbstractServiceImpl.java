package com.intexsoft.sensor.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.intexsoft.sensor.dao.AbstractDAO;
import com.intexsoft.sensor.service.AbstractService;

public class AbstractServiceImpl<E> implements AbstractService<E> {

	private AbstractDAO<E> abstractDAO;

	protected AbstractServiceImpl(AbstractDAO<E> abstractDAO) {
		this.abstractDAO = abstractDAO;
	}

	@Override
	@Transactional
	public E findById(long id) {
		return (E) abstractDAO.findById(id);
	}
	
	@Override
	@Transactional
	public List<E> getAll() {
		return abstractDAO.getAll();
	}

	@Override
	@Transactional
	public void saveOrUpdate(E entity) {
		abstractDAO.saveOrUpdate(entity);
	}

	@Override
	@Transactional
	public void delete(long id) {
		abstractDAO.delete(id);
	}	

	@Override
	@Transactional
	public List<E> findByProperty(String propertyName, Object propertyValue) {
		return abstractDAO.findByProperty(propertyName, propertyValue);
	}

	@Override
	@Transactional
	public E findUniqueByProperty(String propertyName, Object propertyValue) {
		return abstractDAO.findUniqueByProperty(propertyName, propertyValue);
	}

	@Override
	public AbstractDAO<E> getDAO() {
		return abstractDAO;
	}
	
}
