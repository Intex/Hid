package com.intexsoft.sensor.dao.impl;


import org.springframework.stereotype.Repository;

import com.intexsoft.sensor.dao.AdminDAO;
import com.intexsoft.sensor.entity.Admin;


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
