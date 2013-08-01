package hid.dao;

import java.util.List;

import hid.entity.java.Person;

public interface PersonDAO extends AbstractDAO<Person>{
	List<Person> findByFirstName(String firstName);	
	List<Person> findByLastName(String lastName);
	List<Person> getAllPerson();
}
