package hid.dao;


public interface AbstractDAO<E> { // E is entity type
	
	E findById(long id);

	void saveOrUpdate(E entity);

	void delete(long id);
}