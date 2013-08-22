package com.intexsoft.dao.impl;


import org.springframework.stereotype.Repository;

import com.intexsoft.dao.AdminDAO;
import com.intexsoft.entity.Admin;


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
