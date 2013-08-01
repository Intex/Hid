package hid.service;

import java.util.List;

import hid.entity.java.Person;

public interface PersonService extends AbstractService<Person> {
	List<Person> findByFirstName(String firstName);	
	List<Person> findByLastName(String lastName);
	List<Person> getAllPersons();
}
