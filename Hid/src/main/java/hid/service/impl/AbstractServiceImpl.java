package hid.service.impl;

import hid.dao.AbstractDAO;
import hid.service.AbstractService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class AbstractServiceImpl<E> implements AbstractService<E> {
	
	@Autowired
	private AbstractDAO<E> abstractDAO;

	@Override
	@Transactional
	public E findById(long id) {
		return (E) abstractDAO.findById(id);
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

}
