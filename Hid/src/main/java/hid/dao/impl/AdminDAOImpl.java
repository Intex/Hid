package hid.dao.impl;

import hid.dao.AdminDAO;
import hid.entity.java.Admin;

import org.springframework.stereotype.Repository;


@Repository
public class AdminDAOImpl extends AbstractDAOImpl<Admin> implements AdminDAO {

	protected AdminDAOImpl() {
		super(Admin.class);
	}

	@Override
	public Admin findByLogin(String login) {
		return findUniqueByProperty("login", login);
	}
}
