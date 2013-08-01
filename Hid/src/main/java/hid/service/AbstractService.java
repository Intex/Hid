package hid.service;

public interface AbstractService<E> { // E is entity type
	E findById(long id);

	void saveOrUpdate(E entity);

	void delete(long id);

}
