package hid.dao.impl;

import hid.dao.PersonDAO;
import hid.entity.java.Person;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class PersonDAOImpl extends AbstractDAOImpl<Person> implements PersonDAO {

	protected PersonDAOImpl() {
		super(Person.class);
	}

	@Override
	public List<Person> findByFirstName(String firstName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Person> findByLastName(String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Person> getAllPerson() {
		return getCurrentSession().createQuery("from Person").list();
	}

}
