package hid.dao;

import java.util.List;



public interface AbstractDAO<E> { // E is entity type

	E findById(long id);
	
	List<E> getAll();

	void saveOrUpdate(E entity);

	void delete(long id);
	
	List<E> findByProperty(String propertyName, Object propertyValue);
	
	E findUniqueByProperty(String propertyName, Object propertyValue);

}