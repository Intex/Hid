package com.intexsoft.sensor.service;

import java.util.List;

import com.intexsoft.sensor.dao.AbstractDAO;

public interface AbstractService<E> { // E is entity type
	E findById(long id);
	
	List<E> getAll();

	void saveOrUpdate(E entity);

	void delete(long id);
	
	List<E> findByProperty(String propertyName, Object propertyValue);
	
	E findUniqueByProperty(String propertyName, Object propertyValue);
	
	AbstractDAO<E> getDAO();

}
