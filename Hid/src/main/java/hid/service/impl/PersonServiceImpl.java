package hid.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hid.dao.PersonDAO;
import hid.entity.java.Person;
import hid.service.PersonService;

@Service
public class PersonServiceImpl extends AbstractServiceImpl<Person> implements PersonService {
	
	@Autowired
	private PersonDAO personDAO;

	@Override
	@Transactional
	public List<Person> findByFirstName(String firstName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public List<Person> findByLastName(String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public List<Person> getAllPersons() {
		return personDAO.getAllPerson();
	}

}
